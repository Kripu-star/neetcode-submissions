/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> sub = new ArrayList<>();
            for(int i =0 ; i<sz ; i++){
                TreeNode temp = q.poll();
                sub.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!= null) q.add(temp.right);
            }
            list.add(sub);
        }
        return list;
        //T.C. - O(n)
        // S.C. - O(n)
    }
}

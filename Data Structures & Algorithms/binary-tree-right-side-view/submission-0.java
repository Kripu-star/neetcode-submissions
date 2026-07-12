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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        Queue<TreeNode>q = new ArrayDeque<>();
        if(root == null) return list;
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i =0; i<sz ;i++){
                TreeNode temp = q.poll();
                if(i==sz-1) list.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right!= null) q.add(temp.right);
            }
        }
        return list;
        //T.C. - O(n)
        //S.C. - O(n)
    }
}

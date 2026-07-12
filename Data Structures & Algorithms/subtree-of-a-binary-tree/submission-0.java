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
    public boolean check(TreeNode n1, TreeNode n2){
        if(n1==null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        return (n1.val == n2.val) && check(n1.left, n2.left) && check(n1.right, n2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.val == subRoot.val && check (temp, subRoot)) return true;
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        return false;
    }
}

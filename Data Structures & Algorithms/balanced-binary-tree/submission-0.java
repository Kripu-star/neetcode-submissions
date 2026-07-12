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
    boolean breaking = false;
    public int dfs (TreeNode root){
        if(root == null) return 0;
        if(breaking) return -1;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(Math.abs(l-r)>1) {
            breaking = true;
        }
        return (breaking)?-1: 1+Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }
}

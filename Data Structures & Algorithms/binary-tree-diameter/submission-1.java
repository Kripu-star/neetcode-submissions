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
    int max =0;
    public int dfs (TreeNode root){
        if(root == null) {
            //System.out.print("null");
            return 0;
        }
        //System.out.print(root.val +" ");
       int l =  dfs(root.left); // this is the height of the left subtree
       int r =  dfs(root.right); // this is the height of the right subtree
       max = Math.max(max, l+r); //this is the diameter considering the current node
       return 1 + Math.max(l,r); //here we are returning the height of the curret node

    }
    public int diameterOfBinaryTree(TreeNode root) {

        int h =  dfs(root);
        System.out.print(h);
        return max;
    }
}

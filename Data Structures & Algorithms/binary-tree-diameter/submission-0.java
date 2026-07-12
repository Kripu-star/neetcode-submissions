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
    public int height ( TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
      // naive way -> go to each node and ask for the left subtree height + right subtree height + 1
      Queue<TreeNode>q = new ArrayDeque<>();
      q.add(root);
      int max = 0;
      while(!q.isEmpty()){
        TreeNode temp = q.poll();
        max = Math.max(max,  height(temp.left)+height(temp.right));
        if(temp.left != null) q.add(temp.left);
        if(temp.right != null) q.add(temp.right);
      }
      return max;
    }
}

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
    int cnt =0, ans =Integer.MIN_VALUE;
    public void inorder(TreeNode root, int k){
        if(root == null || ans!= Integer.MIN_VALUE) return;
        inorder(root.left, k);
        //System.out.print(root.val+" ");
        cnt++;
        if(cnt == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        //keep doing inorder traversal and the kth element should be returned
    
        inorder(root,k);
        return ans;

        //T.C. - O(height+k) firstly it'll traverse through the left most subtree nodes till it ends then k nodes
        //S.C. - O(height)

    }
}

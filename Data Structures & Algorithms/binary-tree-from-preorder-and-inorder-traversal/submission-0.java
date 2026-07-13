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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // now see in the inorder traversal till the index where we found the root will bw in the left subtree
        //so - root.left = buildTree(some_array, some_other_array);
        int idx = -1;
        for(int i =0 ; i<inorder.length; i++){
            if(inorder[i]== preorder[0]){
                idx = i;
                break;
            }
        }
        int l_preorder [] = Arrays.copyOfRange(preorder, 1, idx+1);
        int l_inorder [] = Arrays.copyOfRange(inorder, 0, idx);
        root.left = buildTree(l_preorder, l_inorder);
        int r_preorder[] = Arrays.copyOfRange(preorder, idx+1, preorder.length);
        int r_inorder[] = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        root.right = buildTree(r_preorder, r_inorder);
        return root;
        //T.C. - O(n*n)
        //S.C. - O(n*n)
    }
}

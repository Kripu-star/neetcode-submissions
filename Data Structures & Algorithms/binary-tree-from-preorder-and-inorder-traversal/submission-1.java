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
    HashMap<Integer,Integer>mp = new HashMap<>();
    int ptr = 0;
    public TreeNode dfs(int[]preorder, int l, int r){
        if(l>r) return null;
        TreeNode root = new TreeNode(preorder[ptr]);
        int mid = mp.get(preorder[ptr++]);
        root.left = dfs(preorder,l,mid-1);
        root.right = dfs(preorder, mid+1,r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i],i);
        }
        return dfs(preorder,0,inorder.length-1 );
        
        //T.C. - O(n*n)
        //S.C. - O(n*n)
    }
}

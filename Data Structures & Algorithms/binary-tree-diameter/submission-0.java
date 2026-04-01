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
    // we need to use recursive approcach for this 
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {

        // recursion means, we need a method.
        // we need a int method.
        longestNode(root);
        return diameter;  
    }

    private int longestNode(TreeNode node) {
        if(node == null) return 0;
        int lh = longestNode(node.left);
         int rh = longestNode(node.right);
         diameter = Math.max(diameter, lh+rh);

         // once diameter calculated, we nned to move back to root node 
         // and add increment by one.
         //
         return Math.max( lh, rh)+1;
    }
}

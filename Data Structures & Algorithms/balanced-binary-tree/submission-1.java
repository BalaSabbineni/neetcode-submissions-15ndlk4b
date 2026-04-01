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
    int val = 0;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int height = height(root);
      
        return val == -1 ? false : true;
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        int dif = Math.abs(left - right);
        if(dif > 1) val = -1;

        return 1+Math.max(left, right);
    }
}

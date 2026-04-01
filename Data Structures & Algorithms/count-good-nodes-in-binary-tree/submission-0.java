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
     
    public int goodNodes(TreeNode root) {
        // need to use dfs amd recursion
        return dfs(root, root.val);   
    }

    private int dfs(TreeNode node, int maxVal) {
        if(node == null) return 0;

        // need to do dfs on left and right
        // only check and important is to confirm node.val > max
        // This is key, checking max value

        int count =0; // this count is track good nodes

        // cheking and updating max value
        if(node.val >= maxVal) {
            // increase count becuase we found good node
            count =1;

            // update max value
            maxVal = node.val;
        }

        return count + dfs(node.left, maxVal) + dfs(node.right, maxVal);
        
    }
}

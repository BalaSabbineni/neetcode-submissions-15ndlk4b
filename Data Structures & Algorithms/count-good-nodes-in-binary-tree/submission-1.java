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
    int count =0;
    public int goodNodes(TreeNode root) {
        
       return  dfs(root, root.val);

        
    }
    private int dfs(TreeNode root, int max){
        if(root == null) return 0;

        int count = 0;
        if(root.val >= max){
            max = root.val;
            count = 1;
        }

        int lc = dfs(root.left,max);
        int rc = dfs(root.right, max);

        return count + lc+rc;

    }
}

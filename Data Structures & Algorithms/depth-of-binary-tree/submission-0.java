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

    // we need to use iterative approach using stack.
    // we need a static class with TreeNode and depth varibale;

     static class NodePath {
        TreeNode nodePath;
        int depth;

        NodePath( TreeNode nodePath, int depth) {
            this.nodePath = nodePath;
            this.depth = depth;
        }
    }
    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int maxDepth = 0;

        // we need stack and push static class with depth increement
        Stack<NodePath> stack = new Stack<>();
        stack.push(new NodePath(root, 1));

        while(!stack.isEmpty()) {
            NodePath current = stack.pop();

            TreeNode currentNode = current.nodePath;
            int currentDepth = current.depth;

            maxDepth= Math.max(currentDepth, maxDepth);

            if(currentNode.left != null) {
                stack.push(new NodePath(currentNode.left, currentDepth+1));
            }

             if(currentNode.right != null) {
                stack.push(new NodePath(currentNode.right, currentDepth+1));
            }


        }

        return maxDepth;
    }
}

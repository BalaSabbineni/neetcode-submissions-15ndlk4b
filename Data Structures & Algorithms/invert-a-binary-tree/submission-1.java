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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        // Using Stack iterative approach, 
        // SWAP is too easy manu times interviewer won't accept swap
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            // first we need to pop root 
            TreeNode node = stack.pop();

            // then we need to do swap
            TreeNode temp = node.left;
            node.left  = node.right;
            node.right = temp;

            // if left is not nulll, push to stack
            if( node.left != null) {
                stack.push(node.left);
            }

            // if right is not nulll, push to stack
            if(node.right != null) stack.push(node.right);    
        }

        return root;

    }
}

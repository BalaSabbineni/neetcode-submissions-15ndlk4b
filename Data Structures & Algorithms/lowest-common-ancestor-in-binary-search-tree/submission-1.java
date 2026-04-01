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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Read question carefully, It's a BST, not BT(max two child).
        // there is difference between BSTa nd BT.
        /*
       1. A Binary Tree is a hierarchical data structure where each node has at most two children, referred to as the left child and the right child. 
       There is no specific ordering requirement for the values within the nodes of a general binary tree. 
        2. A Binary Search Tree (BST) is a specialized type of binary tree that maintains a specific ordering property for its nodes. 
        In a BST:
        All values in the left subtree of a node are less than the value of the node itself.
        All values in the right subtree of a node are greater than the value of the node itself.
        Both the left and right subtrees must also be Binary Search Trees
        */

        while(root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;

    }
}

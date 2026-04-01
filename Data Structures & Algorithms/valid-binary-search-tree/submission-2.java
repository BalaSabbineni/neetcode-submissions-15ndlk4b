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
    public boolean isValidBST(TreeNode root) {
        // we can use two types
        // in-order traversal and recursion
        
        // In-order traversal, we will add vales in [left, root, right]
        // if added list is in assending order, then it's BST.

        // Using recusion: Need to apply logic, less code.

        // 1. Using In-ordeer traversal
        boolean isValid = true;
        List<Integer> result = new ArrayList<>();
         // In-ordeer traversal method

        inorder(root, result);
        System.out.println("1: "+result);
        int prev = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            // check elements in list or in assending or not
            // in asending orde, next element should be greater than prev
            if(result.get(i) <= prev) {
                return false;
            }
            // make current result.get(i) element as prev tpo check assending order or not
            prev = result.get(i);
        }

        return isValid;

    }

    private void inorder(TreeNode root, List<Integer> result) {

        if (root == null) return;

        inorder(root.left, result);
         System.out.println("2: "+result);
        result.add(root.val);
         System.out.println("3: "+result);
        inorder(root.right, result);
    }
}

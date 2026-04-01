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
        // we need to use recursion 
        // as per preorder: [root, left, right], 
        // so we can find root eleemnt from first element of preorder

        // With preorder 1st element, we can identify left and right from inOrder
        // inOrder: [left, root, right]. 
        // we can divide inOrder by half using preOrder first element which is a root

        // So, we need a HashMap to track inOrder elements and divide by root to know left and right
        HashMap<Integer, Integer> hm = new HashMap<>();

        // add inorder elemetnts to HM
        for(int i=0; i < inorder.length;i++) {
            // adds inOrder value and respective index position
            hm.put(inorder[i], i);
        }

        return helper(preorder, 0, 0, inorder.length-1 , hm);
    }

    private TreeNode helper(int[] preorder, int preOrderRoot, int left, int right, HashMap<Integer, Integer> hm) {
        if(preorder == null) return null;

        // As per preorder Definition, root is 1st element of preOrder
        TreeNode root = new TreeNode(preorder[preOrderRoot]);
        System.out.println(root.val);

        // now, we knew the root and we are able to divide inorder by left and right nodes
        // after finding root in inorder, then we will see left and right nodes, 
        // which are again inorder and preorder format.
        
        // create left and right subtrees
        // get mid index whicj is root in inorder
        // we need to use preOrder elements to find root wjhich is 1st element
        int mid = hm.get(preorder[preOrderRoot]);

        // now with this mid, we need to apply recursion
        // now inorder didved in to left and sub tree and we nded to apply binary search
        if(mid>left) {
            root.left = helper(preorder, preOrderRoot+1,left, mid-1, hm);
        }
        // now for right subtree
        if(mid<right) {
            root.right = helper(preorder, preOrderRoot+mid-left+1, mid+1, right, hm);
        }




        return root;
    }
}

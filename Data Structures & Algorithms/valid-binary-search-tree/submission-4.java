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
        List<Integer> ls = new ArrayList<>();
        inorder(ls, root);
        int prev =0;
       for (int i=1; i<ls.size();i++){
        if(ls.get(prev) >= ls.get(i)){
             return false;
        } 
        prev = i;
       }
        return true;
    }

    private void inorder(List<Integer> ls, TreeNode root){
        if(root == null) return;
       
        inorder(ls, root.left);
         ls.add(root.val);
        inorder(ls, root.right);
    }
}

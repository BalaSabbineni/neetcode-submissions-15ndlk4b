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
    public List<Integer> rightSideView(TreeNode root) {
        // we need to use BFS, level wise traversal
        if(root == null) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            // need to know each floor or level of BT
            int levelSize = q.size();
           

            for(int i=0; i< levelSize; i++) {
                // need to poll form queue
                 TreeNode node = q.remove();

                 // this is important, now check size of and right or not.
                 // this logic confirms element is right side or not.
                 if(i == levelSize -1) {
                    result.add(node.val);
                 }

            if(node.left != null) {
                q.add(node.left);
            }
             if(node.right != null) {
                q.add(node.right);
            }

            }  

        }

        return result;


        
    }
}

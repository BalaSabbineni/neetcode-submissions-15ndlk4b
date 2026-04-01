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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // we need to use BFS
        // we have to use queue for BFS
        /*
        1. add root to queue
        2. next, add childs to queue and then pop root.
        3. Now, do same like child as root and add childs child
        4. then, remove root(which is child, that become root)
        */
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return  result;

        // need to use queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        // and add to root as 1st node which is used for iteration
        q.add(root);

        // this levelSize is used to iterate no of times on queue
        int levelSize = 0;

        while(!q.isEmpty()) {
            // to add node values
            List<Integer> levelNodes = new ArrayList<>();
            
            levelSize = q.size();

            for(int i=0; i<levelSize; i++) {
                // remove nodes from queue
                TreeNode node = q.remove();

                // add value to list which is added to result
                levelNodes.add(node.val);

                // add childs to queue
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }

            }
            result.add(levelNodes);
        }


        return result;
    }
}

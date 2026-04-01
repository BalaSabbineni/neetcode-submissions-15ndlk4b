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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // use iterative BFS for this problem
        // we can use recursion, but it's too easy

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        // we need to use Queue for it and 
        // we will add p and q nodes to queue and the pop out
        // to pop out in queue, we need to use queue.poll();
        // then from poped values, we will compares values, null or not etc
        Queue<TreeNode> queue = new LinkedList<>();
        
        // same like stack procedure, add two nodes p & q to queue
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()) {
            // now pop and compare two node
            p = queue.poll();
            q = queue.poll();

            // we did this already so, continue
            if(p == null && q == null) continue;
             if(p == null || q == null) return false;

            if(p.val !=  q.val) return false;
        

            // now add left and right nodes to queue
            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);

        }

        return true;



        
    }
}

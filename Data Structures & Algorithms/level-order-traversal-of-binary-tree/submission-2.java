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
       
          List<List<Integer>> result = new ArrayList<>();
           if(root == null) return result;
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         int qSize =0;
         while(!q.isEmpty()){
            qSize = q.size();
           
            List<Integer> r = new ArrayList<>();

            for(int i=0;i<qSize;i++){
                 TreeNode node = q.remove();
                
                 if(node.left != null){
                     q.add(node.left);
                 }
                 if(node.right != null){
                    q.add(node.right);
                 }
                  r.add(node.val);
            
                
            }
            
            result.add(r);
         }

         return result;   
    }
}

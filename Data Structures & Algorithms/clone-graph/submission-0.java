/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
    we need to do deep copy og undirected graph
    deep copy menas,need new graph exactly as original

    we need to use DFS and visted array
    */

    // we need a hashMap to track prev Node and new Node node relationship
    HashMap<Node, Node> hm = new HashMap<>();

    public Node cloneGraph(Node node) {


        if(node == null) return null;

        // we need a new node, so create new node with given input Node
         // In this step, we'll get a new node with given node value
        Node deepCopyNode = new Node(node.val);

        // Now add this newly created deepCopiedNode to HM to check it visted or not
        hm.put(node, deepCopyNode);
       
        // and need to neighbors. for that we just need to loop on it
        for(Node neighbor : node.neighbors) {
            // add neighbors to deepCopyNode
            // AND at same time we need to do DFS 
            // AND we need to check neighbor is already visted or not.

            
            if(hm.get(neighbor) == null) {
                deepCopyNode.neighbors.add(cloneGraph(neighbor));
            } else {
                 deepCopyNode.neighbors.add(hm.get(neighbor));
            }
            
        }

        
        return deepCopyNode;
        
    }
}
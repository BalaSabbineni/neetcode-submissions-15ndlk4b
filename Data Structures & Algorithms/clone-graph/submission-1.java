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
    we need a depp copy of give node. which means need to create a new node from given node
    */

    HashMap<Node, Node> hm = new HashMap<>();
    public Node cloneGraph(Node node) {

        if(node == null) return null;

       // create adeepCopyNode from new node by passing new node val;
       Node deepCopyOfNode = new Node(node.val);

       // after adding node to deepCopy update hm to track as visited
       hm.put(node, deepCopyOfNode);

       // now we need to add neighbors yo deepCopyOfNode.
       // so, we need to iterate on given input node to check any neighbors

       for(Node neigh: node.neighbors) {

        // add neigbour to deepCopy's list and do DFS. we need a HashMap
        // check hm to check neighbour is added or not.
        // this is triky, understand cleatly.
        if(hm.get(neigh) == null) {
            // this means neighbor not added and need to do DFS
             deepCopyOfNode.neighbors.add(cloneGraph(neigh));
        }
        else {
            // if node is already there, we just add to neighour relation by getting from hm
            deepCopyOfNode.neighbors.add((hm.get(neigh)));}
       }

       return deepCopyOfNode;


        
    }
}
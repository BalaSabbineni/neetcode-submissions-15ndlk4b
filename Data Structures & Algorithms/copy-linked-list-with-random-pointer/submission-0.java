/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // Step 1
       // we need to introduce new node between original nodes

       Node curr = head;
       while(curr != null) {
        Node newNode = new Node(curr.val);
        newNode.next = curr.next;
        curr.next = newNode;
        curr= newNode.next;
       }

       //step 2
       // now we need to map random nexts to newNode;
       curr = head;
       while(curr != null) {
        if(curr.random != null) {
             curr.next.random = curr.random.next;
        }
    
        curr = curr.next.next;
       }

       // step 3
       // extract newnode

       curr = head;
       Node newHead = head.next;
       Node newCurr = newHead;

       while(curr != null) {
        curr.next = newCurr.next;
        curr = curr.next;
        if(curr != null) {
         newCurr.next = curr.next;
         newCurr = newCurr.next;
       }
       }

       return newHead;
        
    }
}

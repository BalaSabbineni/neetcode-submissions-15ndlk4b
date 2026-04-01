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
        // We need to place newNode betwen existing nodes and 
        // map next nodes.
        Node cur = head;
        while(cur !=null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        // Step 2
        // Now we need to map random of new nodes
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
             cur = cur.next.next;
        }

        // Step 3
        // Now we have LS with orignal Node, new Node ...
        // And all the next and random mappings
        // Now need to seprate new Node which will be deep copy
        cur = head;

        // this newHead is where our newNode starts
        // need to map this head and return it;
        Node newHead = head.next;
        Node newCur = newHead;

        while(cur != null) {
            cur.next = newCur.next;
            cur = cur.next;
            if(cur != null) {
                newCur.next = cur.next;
                newCur = newCur.next;
            }
        }

        return newHead;

        
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
      /*
         * To solve this problem, we need to 2 important things
          1. Keep track of
          * previous node
          * current node
          * next node
          2. Algorithm
          * store the next node, so you don't lose it.
          * next pointer of current node will point to previous node
          * the previous node will become current node
          * current node will become next node
          *
         */
        /*
         *LinkedList has nodes with two parts which has first block has data and 2nd block has direction or address to next node.
         * If we change next node address to previous one. Then LS will be revered.
         * example: 1->2->3->4->null
         * reversed: If we update next address to previous one, it will be like this
         *           1<-2<-3<-4<-, same as 4->3->2->1
         *
         * So, to update this we need three pointers like previous node, current node, next node
         * First node is head.
         * As per above Algorithm, for this example 1->2->3->4
         *  First, we need to store next node. that means currently, we are head i.e., 1. we need to store next node which is 2.
                     next = current.next; current.next has address of next node.
         * Second, we need to point current node address to previous node. changing arrow direction like this [ null <-1 ]from  [ null->1-> ]
         * Third, we need to update current node which is 1 as previous. Before this previous is null.
           Initially like this 1->, In this previous is null. After third step updating, [null<-1 <- 2],  1 becomes previous
         * fourth, make current element as next. which is 2.
         *
         * this way we can reverse LS.
         * Read and understood Algorithm carefully, then it will be easy
         *
         */
        ListNode nextNode = null;
        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode != null) {
            // example [1,2,3,4] for 1st iteration
            // here  currentNode =1, nextNode= null, previousNode= null
            nextNode = currentNode.next; // here we are storing next node address(nextNode = 2 address)

            // here node with value 1 next address update to previous which is null.
            // arrow direction changed to null <- 1 from 1->2
            currentNode.next = previousNode;

            // here previous node is 1 node address
            previousNode = currentNode;

            // nocde 2 becomes current node. so, we store next node info in nextNode variable
            currentNode = nextNode;
        }
        return previousNode;  
    }
}

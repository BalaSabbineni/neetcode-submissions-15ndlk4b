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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        To find the nth form end, we need to use two pointer approach.

        We need to use dummy to the return result.
        We can use any head for this dummy node like -1 or 0. and dummy next will be given head.
        In the end we just use dummy.next as result

        First In advance, we need to move 2nd pointer n times on dummy node.
         
        two pointer start at one head and one will move at speed 1 and another one will move speed n.


        Next move two pointer at same speed using while. here one pointer is at dummy head and another one is at dummy's nth position
        If 2nd pointer's next is null. then our target will be 1st pointer's next node(which is nth node)
         */


        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // move 2nd pointer n spaces ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // after breaking while loop, our traget is at slow.next element. we need to remove it, right?
        // so, move next pointer address to next.next
        slow.next = slow.next.next; // removing our target number

        return dummy.next;

        
    }
}

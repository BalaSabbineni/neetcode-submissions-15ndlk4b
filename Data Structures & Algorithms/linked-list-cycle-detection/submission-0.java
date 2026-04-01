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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode currentNode = head;
        ListNode currentNodeNext = head.next;

        while (currentNode != currentNodeNext) {
            if (currentNode.next == null || currentNodeNext.next == null) {
                return false;
            }
            currentNode = currentNode.next;
            currentNodeNext = currentNodeNext.next.next;
            
        }
        return true;
    }
}

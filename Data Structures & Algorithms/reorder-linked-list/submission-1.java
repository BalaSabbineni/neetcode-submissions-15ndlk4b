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
    public void reorderList(ListNode head) {
      if (head == null || head.next == null) return;
// [0, n-1, 1, n-2, 2, n-3, ...]
        /*
         * we need to divide LS in half
         * and then reverse the 2nd half and then merge two halfs.
         * Then, we can achieve this [0, n-1, 1, n-2, 2, n-3, ...]
         */
        /*
        [0, 1, 2, 3, 4, 5, 6]
        [0, 1, 2, 3]
        [4, 5, 6]
        {6,5,4]
        [0, 6, 1, 5, 2, 4, 3]
         */
        /*
        We need to three steps
         * First, find the midpoint of LS
         * then reverse the 2nd half of LS
         * Finally, merge two half's
         */

        // Finding Midpoint
        /*
        This is easy part. Think, Concentrate and focus carefully. Find a way to identify midpoint.
        Use turtle and rabbit approach two pointer approach
         */

        // For first half, use this l1
        ListNode l1 = head;

        // to find midpoint use, slow and fast algorithm
        ListNode slow = head;
        ListNode fast = head;

        // use this prev to split to half
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // once this while loop breaks, slow will be at midpoint, to different as two halfs, make prev null
        prev.next = null; // this check so important. This make two halfs.¬

        // now REVERSE 2nd half. Here 2nf half starts from slow and ends with fast;
        ListNode l2 = reverse(slow);

        // merge tow lists
        merge(l1, l2);


    }

    private void merge(ListNode l1, ListNode l2) {
       
        // here l1 = 0,1,2,3
        // l2 = 6,5,4
        while (l1 != null) {
            // comments are only for 1st iteration
            ListNode l1_next = l1.next; // 1
            ListNode l2_next = l2.next; // 5
            l1.next = l2; // after this l1 = 0,6

            if (l1_next == null) {
                break;
            }
            l2.next = l1_next; // after this
            l1 = l1_next;
            l2 = l2_next;


        }
    }

    private ListNode reverse(ListNode slow) {
        ListNode currentNode = slow;
        ListNode previousNode = null;
        
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
        
     
    
}

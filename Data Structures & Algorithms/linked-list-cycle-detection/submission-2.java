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
        /*
         * First, read and understood the question.
         *
         * We need to find the LS has cycle or not.

         * Cycle means we need the end of for LS. Means, Last node of LS should have null address.
         *
         * To check that we need to use two pointer approach using slow and fast algorithm.
         * Example, take rabbit and turtle running race. If running track is circular, rabbit meets turtle after finishing cycle.
         * example with LS. LS = [1,2,3,4].
         * Here, turtle and rabbit starts at 1. Rabbit runs faster right. If LS is circle then rabbit can collide with turtle at 2 or 3 or 4.
         * If LS is not circular, that means any has next address as null. Then race ends and no collision.
         *
         * So, To check this we need to use two pointer with one pointer as slow and another one fast.
         * slow starts at LS head and fast starts at LS heads next. element.
         * If any head.next  has null, then there is no cycle and return false, else true.
         *
         * To check cycle exists, take slow as head (which is 1st element in LS) and fast as head.next (which is 2nd element in LS)
         *
         * we have to use while loop until slow not equal to fast(means rabbit not collide with turtle)
         * update slow fast to next elements. If cycle is there, while loop breaks, if not No and check slow.next or fast.next is null.
         */

        if (head == null) {
            return false;
        }
        // LS = [1,2,3,4]
        ListNode slow = head; // think like turtle at 1 element
        ListNode fast = head.next; // think like rabbit at 2 element

        while (slow != fast) { // need to check rabbit doesn't meet turtle. If meets break while loop and return true as cycle exists.

            /*
            This check to check rabbit already reached the run destination and no return back. means no cycle.¬
             */
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next; // updating to next postion

            /*
             *updating to rabbit position to next.next position just for faster execution.
             * We need to use  fast.next.next,  because of how Floyd’s Cycle Detection Algorithm works (also called the “Tortoise and Hare” method).
             * By making fast move twice as fast (fast.next.next), we ensure that:
             * In a cyclic list, fast will eventually "lap" slow and meet it.
             * In a non-cyclic list, fast will hit null first, so we know there’s no cycle.
             */

            /*
             * we can't use fast.next
             * If both slow and fast move at the same speed (slow.next and fast.next),
             * then their relative positions never change — they’ll stay the same distance apart forever,
             * so they might never collide unless they start at the same node.
             */
            fast = fast.next.next;

        }
        return true;
        
    }
}

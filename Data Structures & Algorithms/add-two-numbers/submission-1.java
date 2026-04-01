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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        We need to add numbers. Here numbers are in Linked List.
        Example. read question.
        If L1 = 1 2 3, L2 =  4,5,6
        we need to add from backside like this 321 + 654 = 975

        After adding one num from each and if result got two digits
        we need to store the last in "carry"
        example: 9+9=18, we will add 8 to result LL and 1 to carry
        and we will add this carry to next element add.
        To get the carry, use sum/10. then we will get carry = 1 from 18.
        To get 8 which is needed for adding to result. use sum % 8, then we get 8.

        First, we need to use 2 pointer.
        one is for retuning result which is LL  reuslt = new LL(0);
        2nd pointer is any name , ptr = reuslt; and move this ptr.

        finally return result.next;


        */
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0 + carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;

            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1) {
            ptr.next = new ListNode(1);
            // ptr = ptr.next;
        }
        return result.next;


    }
}

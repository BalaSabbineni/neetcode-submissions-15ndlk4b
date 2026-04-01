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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         /*
         * Read Question carefully, We have two sorted linked lists and we need to merge it.
         *  Below are some edge cases.
         */
        if(list1 == null && list2 == null) return list1;
        if(list1 == null ) return list2;
        if(list2 == null) return list1;

        ListNode result;

        if(list1.val < list2.val) {
            result = list1;
            list1 = list1.next;
        } else{
            result = list2;
            list2 = list2.next;
        }
        result.next = mergeTwoLists(list1, list2);

        return result;

        


 
        
    }
}
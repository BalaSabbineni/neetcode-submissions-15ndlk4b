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

       // if (list1 == null && list2 == null) return new ListNode();
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        /*
         * We need to merge it, right? so we need a new linked list, take it as newHead.
         * Now, we need compare head of list1 and list2. why because we need to merge in ascending order. so, we need to know which list head is less
         * Once we found less value from two lists, add that less value head to new merged linkedList's 'newHead' head.
         * After adding less value lists head to  merged linkedList's head,
         * we need to update current list head i.e., list1 or list2 to next of list as new head.
         * why because we added the previous head to mergedLinkedList. so, we don't need it and need new head to compare next values
         *
         * After comparing two lists head and finding less value from two heads, we added head to mergedLinkedList
         * Now, To add next or 2nd element to mergedLinkedList, we need to use recursive procedure.
         * recursive function base condition is untill we found list1 or list 2 null;
         * Once we meet  list1 or list 2 null, we stop our recursive function
         */
        ListNode newHead;
        //  list1 = [1,2,4], list2 = [1,3,5]


        if (list1.val < list2.val) { // comparing two lists head values
            newHead = list1; // adding list1 head value to newHead(which is our merged one)
            list1 = list1.next; // we finished using current head, next we need to compare with next element so, updating head to next value
        } else {
            newHead = list2;
            list2 = list2.next;
        }


        // this to add next value to newHead(mergedList), we calling recursive function
        // In the above if else condition, we checked list1 and list 2 head values and added
        // and added less value to newHead(mergedList) head. So, for cheking another value, we need to call this function.
        // so, we need to use recursive function
        newHead.next = mergeTwoLists(list1, list2);
        return newHead;
        
    }
}
Remove Nth Node From End of List Jan 28 '124254 / 11279
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || n < 1)  return null;
   
        
        ListNode l1 = head, l2 = head, l3 = head;
        for(int i = 0; i < n ; i++){
            if(l1 == null)
                return null;
            l1 = l1.next;
        }
        
    
       while(l1 != null){
            l3 = l2;
            l2 = l2.next;
            l1 = l1.next;
        }
        if(l2 == head) return head.next;
        l3.next = l2.next;
        
        return head;
        
    }
}

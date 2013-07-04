Swap Nodes in Pairs Feb 15 '123527 / 7954
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space.
You may not modify the values in the list, only nodes itself can be changed.

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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null)
            return head;
            
        ListNode l = null, r = null, n = null, c = head;
        head = head.next;
        
        while(c != null && c.next != null){
          //  l = c;
            r = c.next;
            n = c.next.next;
            
            if(l != null)
                l.next = r;
            r.next = c;
            c.next = n;
            
            l = c;
            c = n;

            
        }
        
        return head;
        
    }
}

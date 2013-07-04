Add Two Numbers Nov 1 '115865 / 19404
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain 
a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        
        int length1  =0, length2 =0, length3 = 0;
        ListNode c1 = l1, c2 = l2;
        
        while(c1 != null){
            length1++;
            s1.push(c1.val);
            c1 = c1.next;
        }
        
        while(c2 != null){
            length2++;
            s2.push(c2.val);
            c2 = c2.next;
        }
        
        if(length1 == 0) return l2;
        if(length2 == 0) return l1;
                
        if(length1 < length2){
            length3 = length2;
            length2 = length1;
            length1 = length3;
            
            ListNode l3 = l2;
            l2 = l1;
            l1 = l3;
            
            s3 = s2;
            s2 = s1;
            s1 = s3;        
        }
        
        ListNode root = new ListNode(0);
        ListNode cc = root;
        int temp = 0;
        
        while (length1 > 0){            
            int sum = 0;
            if(length2 > 0){
                sum = l2.val;
                length2--;
                l2 = l2.next;
            }
            sum = sum + l1.val + temp;
            l1 = l1.next;
            if(sum > 9){
                sum -= 10;
                temp = 1;
            }else{
                temp = 0;
            }
            
            ListNode c = new ListNode(sum);
            cc.next = c;
            cc = cc.next;
            length1--;
        }
        
        if(temp == 1){
             ListNode c = new ListNode(temp);
             cc.next = c;
             cc = c.next;
        }
            
        return root.next;
        
    }
}


==============================================================================================
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode rootListNode = new ListNode(-1);
    ListNode currentListNode = rootListNode;

    while (l1 != null || l2 != null) {
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        if (sum >= 10) {
            carry = 1;
            sum -= 10;
        } else {
            carry = 0;   
        }
        currentListNode.next = new ListNode(sum);
        currentListNode = currentListNode.next;
    }
    if (carry == 1) {
        currentListNode.next = new ListNode(carry);
    }

    return rootListNode.next;
}

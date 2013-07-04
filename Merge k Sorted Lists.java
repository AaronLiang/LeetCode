
Merge k Sorted Lists Feb 14 '123618 / 12330
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

» Solve this problem

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
     public static ListNode mergeKLists(ArrayList<ListNode> lists) {
      // Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null || lists.size() == 0)
			return null;
		ListNode root = new ListNode(0);
		ListNode current = root;

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {
					@Override
					public int compare(ListNode l1, ListNode l2) {
						return l1.val < l2.val ? -1
								: (l1.val == l2.val ? 0 : 1);
					}
				});

		for (ListNode l : lists) {
			if (l != null)
				heap.add(l);
		}

		while (heap.size() > 0) {
			current.next = heap.poll();
			current = current.next;
			if (current.next != null)
				heap.add(current.next);

		}

		return root.next;
	}
}





=========================Error=======================
public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.size() ==0) return null;
        ListNode root = new ListNode(0);
        ListNode current = root;
        ListNode s = new ListNode(Integer.MAX_VALUE);
        while(true){
            int num = 0;
            int index = 0;
            for(int i = 0; i < lists.size(); i++){
                ListNode n = lists.get(i);
                if( n == null){
                   num++;
                   continue;
                }
                if(s.val > n.val){
                    s = n;
                    index = i;
                }        
            }
            current.next = s;
            current = current.next;
            lists.remove(index);
            lists.add(index,s.next);
            if(num == lists.size())
                break;
          }
        return root.next;
    }

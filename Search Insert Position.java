Search Insert Position Mar 3 '123811 / 7616
Given a sorted array and a target value, 
return the index if the target is found. 
If not, return the index where it would 
be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

» Solve this problem

public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        if(target <= A[0]) return 0;
        for(i = 1; i < A.length; i++){
            if(target == A[i]) return i;
            if(target > A[i-1] && target < A[i] ) return i;
        }
        return i;
    }
}

======================================================
public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        for(; i < A.length ; i++){
            if(target <= A[i]) break;
        }
        return i;
    }

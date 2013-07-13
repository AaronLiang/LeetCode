Merge Sorted Array May 20 '123740 / 8417
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.


public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) return;
        m--;n--;
        while(n >= 0){
            if(m < 0 || A[m] < B[n]){
                A[m + n+1] = B[n--];
            }else{
                A[m + n+1] = A[m--];
            }
        }        
    }
}

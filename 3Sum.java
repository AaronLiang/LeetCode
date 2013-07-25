3SumJan 18 '123944 / 14700
Given an array S of n integers, are there elements a, b, c in 
S such that a + b + c = 0? Find all unique triplets in the 
array which gives the sum of zero.

Note: http://discuss.leetcode.com/questions/15/3sum

Elements in a triplet (a,b,c) must be in non-descending order. 
(ie, a ? b ? c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
    ================================================================
    public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {  
      ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();  
      if (num.length < 3) return resSet;  
      Arrays.sort(num);  
      for (int i=0; i<num.length-2 && num[i]<=0; ++i) {  
        // remove duplicates  
        if (i>0 && num[i]==num[i-1]) continue;  
        // use two pointer to find b+c = -a  
        int start=i+1, end=num.length-1;  
        while (start<end) {  
          int sum = num[i] + num[start] + num[end];  
          if (sum < 0) {  
            start++;  
          } else if (sum > 0) {  
            end--;  
          } else { // find one  
            ArrayList<Integer> res = new ArrayList<Integer>(3);  
            res.add(num[i]);  
            res.add(num[start]);  
            res.add(num[end]);  
            resSet.add(res);  
            // move the left pointer to right and skip duplicates;  
            do { start++; } while (start<end && num[start]==num[start-1]);  
            // move the right pointer to left and skip duplicates  
            do { end--; } while (start<end && num[end]==num[end+1]);  
          }  
        }  
      }  
      return resSet;  
    }
}
    ===========================================================================
    
    
        public ArrayList<ArrayList<Integer>> threeSum(int[] num1) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(num1.length < 3) return lists;
        Arrays.sort(num1);
        
        for(int i = 0; i < num1.length-2; i++){
            if( i > 0 && num1[i] == num1[i-1]) continue;
            for(int j = i+1; j < num1.length-1; j++){
                 if( j > i+1 && num1[j] == num1[j-1]) continue;
                 for(int k = j+1; k < num1.length; k++){
                  if(k > j +1 && num1[k] == num1[k-1]) continue;  
                   if (num1[k] == 0- num1[i]-num1[j]){
                       ArrayList<Integer> array = new ArrayList<Integer>();
                       array.add(num1[i]);
                       array.add(num1[j]);
                       array.add(num1[k]);
                       lists.add(array);
                   }
                 }
            }
        }
        return  lists; 
    }

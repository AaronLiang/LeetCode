Palindrome Partitioning Feb 284563 / 15871
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
  
  
  http://discuss.leetcode.com/questions/1265/palindrome-partitioning
  
============================================================================== 
  public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> array = new ArrayList<String>();
        for(int i = 0; i < s.length(); s++){
            array.add(s.substring(i,i));
        }
        lists.add(array);
        
        while(true){
            
            
        }
    }
}
  

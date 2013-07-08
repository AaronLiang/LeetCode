Combinations Apr 18 '123255 / 8091
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n < k || k < 0) return null;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if ( k == 0 ) return lists;
        
        if ( k == 1){
            for (int i = 1 ; i <= n; i++){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                lists.add(list);
            }
            return lists;
        }
        
        for(int i = n; i >= k; i--){
            ArrayList<ArrayList<Integer>> currentlist = combine(i-1, k-1);
            for(ArrayList<Integer> list : currentlist){
                list.add(i);
                lists.add(list);
            }
        }
        return lists;
    }
}

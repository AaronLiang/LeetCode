Subsets Apr 18 '123809 / 9799
Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
» Solve this problem



public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S == null) return null;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(S.length == 0) return lists;
        Arrays.sort(S);// Why need to sort??????????????
        for(int i = 0; i < S.length; i++){
            ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> temp: lists){
                c.add(new ArrayList<Integer>(temp));
            }
            
              for(ArrayList<Integer> temp: lists){
                  temp.add(S[i]);
            }
            
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(S[i]);
            c.add(temp);
            
            lists.addAll(c);
            
            
        }
        
         ArrayList<Integer> temp = new ArrayList<Integer>();
         lists.add(temp);
         return lists;
    }
}

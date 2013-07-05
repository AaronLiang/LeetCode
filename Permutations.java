
Permutations Mar 17 '123698 / 8522
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

http://blog.csdn.net/tuantuanls/article/details/8717262



public class Solution {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(num.length ==0 ) return null;
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(num[0]);
        list.add(array);
            
        if(num.length == 1){           
            return list;
        }
        
            
        list = Solution.helpFun( num, 1, list);
        return list;
    }
    
    public static ArrayList<ArrayList<Integer>> helpFun(int[] num, int index, ArrayList<ArrayList<Integer>> lists){
        if(num.length == index ) return lists;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        int size = lists.size();
        int length = lists.get(0).size();
        
        for(int i = 0 ; i < size; i++){
            array = lists.get(i);
            
            for(int j = 0; j < length + 1; j++){
               ArrayList<Integer> temp = new ArrayList<Integer>(array);
               temp.add(j,num[index]);
               list.add(temp);
            }
        }      
        return helpFun(num, index + 1, list);    
        
    }
}



====================================================================================
Problem Description:

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Further question is if the collection of numbers contain duplicates, 
how to return all possible unique permutations.

Solution and Precautions:
uestion is not difficult, but the second unique permutations might 
involve sophisticated thinking. I just read other people’s report 
and then know how to solve it, so I don’t bother to write repeated 
stuff here.  
One could check http://blog.csdn.net/morewindows/article/details/7370155 first.

Backtracking (DFS) is the standard way to find all the 
permutations of a given set of numbers. The first q
The tricky thing is that, to avoid duplicates, when we 
do swapping between num[k] and num[i], we need to make 
sure in the interval [k, i), there is no number with the 
same value as of num[i]. This could be explained like this: 
(1) to avoid duplicated permutation, we just need to avoid
permute the same numbers; (2) suppose there is a duplicated
number of num[i] in [k, i), then sometime in the future after
we have done the swapping(num[k], num[i]), we will also swap
this duplicated number with num[i], that is, we are essentially
swapping the same numbers. (3) it is not enough to check just 
num[k] and num[i] whether they are the same number when swapping
them because of (2), and (2) also includes the case that we check 
num[k] and num[i] are same or not. Combine (1) , (2) and (3), we
make sure we don’t swap the same numbers and thus avoiding all the
duplicated permutations. 

The solution here in the link involves linear scan through [k, i)
to check whether there is duplicates of num[i], this linear scan 
might be saved by first sorting all the numbers, a different approach
could be find in 
http://fisherlei.blogspot.ca/2012/12/leetcode-permutations-ii.html. 
But this sorting seems could not be directly integrated into the 
previous solution to save the linear scan since after swapping, 
the order is disturbed anyways.

TO BE CONTINUED!

Tips and Divergent thinking:

Update on April 27, 2013. There is another (systematic) way to 
remove the duplicates as in another post “leetcode: Subsets I and II“:

if two adjacent numbers say A and B are equal, then only when A is used, 
B could be used in that subset.

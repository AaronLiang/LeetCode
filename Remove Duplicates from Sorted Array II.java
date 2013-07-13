
Remove Duplicates from Sorted Array II   A pr 19 '122848 / 7062
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].



   public int removeDuplicates(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(A.length < 3) return A.length;
    int num = 1, count = 1;
    
    for(int i = 1; i < A.length; i++){
        if(A[i-1] == A[i]){
            count++;
        }else{
            count =1;
        }
        
        if(count <=2 ){
            A[num++] = A[i];
        }
        
    }
    return num;
   }

============================================================================
public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length < 3) return A.length;
        int num = 0;
        int count = 1, i =1;
        for(; i < A.length-num; i++){
            if(A[i-1] == A[i]){
                count++;
                continue;
            }else if(count > 2){
                A = helpFun(A, i - count +1 , count - 2 );
                num =  num + count -2;
            }    
            count = 1;
        }
        if(count > 2){
            A = helpFun(A, i - count +1, count - 2 );
            num =  num + count -2;
        }        
        return A.length - num  ;
    }
    
    public int[] helpFun(int[] x, int start, int n){
        int[] p = new int[x.length];
        for(int j = 0; j < x.length - n; j++ ){
            if(j < start){
                p[j] = x[j];
            }else{
                p[j] = x[j+n];
            }
        }
        return p;
        
    }
    
}

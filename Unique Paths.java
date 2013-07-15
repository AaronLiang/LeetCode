public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m ==1 && n == 1) return 1;
                
        if(m == 1 )
            return uniquePaths(1, n-1);
        else if (n == 1)
            return uniquePaths(m-1, 1);
        else
            return uniquePaths(m-1, n)+ uniquePaths(m, n-1);
        
    }
}   

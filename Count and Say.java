Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.



public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 1)
            return null;
        if(n ==1 ) return "1";
        
        
        StringBuffer sb = new StringBuffer("11");
        for(int i = 2; i < n; i++){
            StringBuffer c = new StringBuffer();
            int count = 1;
            for( int j = 1; j < sb.length();j++){
                if(sb.charAt(j-1) == sb.charAt(j)){
                    count++;
                }else{
                    c.append(count);
                    c.append(sb.charAt(j-1));
                    count = 1;
                }
            }
            c.append(count);
            c.append(sb.charAt(sb.length()-1));
            sb = c;
        }
        return sb.toString();
    }
}

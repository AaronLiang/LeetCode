Longest Common Prefix Jan 17 '124343 / 12040
Write a function to find the longest common prefix string amongst an array of strings.


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(String s : strs){                
                if(s.length() <= i || s.charAt(i) != ch) // <= i!!!
                    return sb.toString();
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}

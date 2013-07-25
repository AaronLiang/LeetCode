Anagrams Mar 19 '123312 / 10830
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

Anagrams Mar 19 '123312 / 10830
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.



public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> anagram = new ArrayList<String>();
        HashMap<String,ArrayList<String>> list = new HashMap<String,ArrayList<String>>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (list.containsKey(key)) {
                list.get(key).add(str);
            } else {
                list.put(key,new ArrayList<String>(Arrays.asList(str)));
            }
        }
        for (ArrayList<String> test:list.values()) {
            if (test.size()>1) {
                anagram.addAll(test);
            }
        }
        return anagram;
    }
}
=======================================================================================================

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String>();

        if(strs.length < 2) return list;
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(strs));//Arrays api
        
        while(array.size() > 0){
            boolean flag = false;
            String str = array.get(0);
            array.remove(0);

            java.util.Hashtable<Character, Integer> table = new java.util.Hashtable<Character, Integer>();
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if(table.containsKey(ch)){
                    table.put(ch, table.get(ch)+1);
                }else{
                    table.put(ch, 1);
                }
            }
            
            for(int i = 0 ; i < array.size(); i++){
                java.util.Hashtable<Character, Integer> currentTable = (java.util.Hashtable<Character, Integer>) table.clone();
              //Copy the table to current table!!!!!
                String temp = array.get(i);
                boolean b = false;

                if(str.length() != temp.length())
                    continue;
                    
                for(int j = 0; j < temp.length(); j++){
                    char ch = temp.charAt(j);
                    if(currentTable.containsKey(ch) && currentTable.get(ch) >0 ){
                      currentTable.put(ch, currentTable.get(ch)-1);
                    }else{
                       b = true;
                       break;
                    }
                    if(b) break;
                }
                
                if(b) continue;
                if(!flag)
                    list.add(str);
                flag = true;
                list.add(temp);
                array.remove(i);
                i--;    
                
            }
        }
        return list;
    }
}

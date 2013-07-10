Word Search Apr 18 '124131 / 13344
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.




public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(word == null || word.equals("") ||word.trim().equals(""))
            return true;
        word = word.trim();
        int row = board.length, column = board[0].length;
        if(row == 0  || row * column < word.length())
            return false;
        
        java.util.Hashtable<Character, Integer> table = new java.util.Hashtable<Character, Integer>();
         
        for(int i = 0; i < row; i++){
            for(int j = 0; j< column; j++){
                if(table.containsKey(board[i][j]) ){
                    table.put(board[i][j],table.get(board[i][j]) + 1 );
                }else{
                    table.put(board[i][j],1);
                }
            }
        }
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(table.containsKey(ch) && table.get(ch) > 0){
                table.put(ch, table.get(ch) - 1);
            }else{
                return false;
            }
        }
           
        return true;
    }
}

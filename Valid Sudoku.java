
Valid Sudoku Mar 3 '122213 / 6964
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.



A partially filled sudoku which is valid.



public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] r = new boolean[9][9];
        boolean[][] c = new boolean[9][9];
        boolean[][] b = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; i< 9; i++){
                r[i][j] = false;
                c[i][j] = false;
                b[i][j] = false;
            }
            
        }
        
        for(int i =0; i < 9; i++){
            for(int j = 0; j < 9;j++){
                char ch = board[i][j];
                if( ch != '.'){
                    int x = ch -'1';
                    if(r[i][x] || c[x][j] || b[i - i % 3 + j / 3][x])
                        return false;
                    r[i][x] = true;
                    c[x][j] = true;
                    b[i - i % 3 + j / 3][x] = true;
                }
            }
                    
        }
        return true;
    }
}

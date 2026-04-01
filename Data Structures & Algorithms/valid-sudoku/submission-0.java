class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i< 9; i++) {
            for (int j=0;j<9;j++) {
                char num = board[i][j];

                if(num != '.') {
                  if(!seen.add(num + "added row" + i) ||
                   !seen.add(num + "added column" + j) ||
                   !seen.add(num + "added 3 * 3 box" + i/3 + "-" + j/3)) {
                    return false;
                   } 
                }

            }
        }
        return true;
        
    }
}

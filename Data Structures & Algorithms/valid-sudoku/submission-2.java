class Solution {
    public boolean isValidSudoku(char[][] board) {
HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if (ch != '.') {
                    if (!hs.add(ch + "added I: " + i) ||
                            !hs.add(ch + "added J: " + j) ||
                            !hs.add(ch + "added i/3 and j/3: " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }

            }
        }
        return true;
        
        
    }
}

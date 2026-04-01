class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if (ch != '.') {
                    if (!seen.add(ch + "added i" + i) ||
                            !seen.add(ch + "added j" + j) ||
                            !seen.add(ch + "added at 3 * 3 " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }

            }
        }
        return true;
        
    }
}

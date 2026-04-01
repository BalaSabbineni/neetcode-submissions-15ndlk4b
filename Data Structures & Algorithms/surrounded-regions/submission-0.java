class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // we need to iterate border and mark as escape

        /**
         top bottom borders abnd do dfs on neoghtbors
         this means, top row which is 0 and end of cols
                    bottom whuch is rowslength-1 and end of cols
         */
        for (int c = 0; c < cols; c++) {
            // check top boarder which is oth row and end of cols. so, we need to iterate until cols
            if (board[0][c] == 'O')
                dfs(board, 0, c);

            // check bottom boarder which is at rowsLength -1 and end of all cols
            if (board[rows - 1][c] == 'O')
                dfs(board, rows - 1, c);
        }

        /**
        left anf right boarders
         */
        for (int r = 0; r < rows; r++) {
            // check left boarder
            if (board[r][0] == 'O')
                dfs(board, r, 0);

            // check right boarder
            if (board[r][cols - 1] == 'O')
                dfs(board, r, cols - 1);
        }

        // revert back those escapes

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'E')
                    board[r][c] = 'O';

            }
        }

    }

    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;
        // update boarder element as escape
        board[r][c] = 'E';

        // now do dfs on neighbor eleements
        int[][] neighbors = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] neigh : neighbors) {
            // get neighbor coordinates
            int nr = r + neigh[0];
            int nc = c + neigh[1];

            // check index boundary and element equal to "O" to replace t0 "X"
            // IMPORTANT: why this check this, if boarder element (3,1) = "O".
            // Then If it's  neighbour is "O", we should not replace as "X", thats why why we are recussing and updating to escpae "E
            if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && board[nr][nc] == 'O') {
                dfs(board, nr, nc);
            }
        }

    }
}
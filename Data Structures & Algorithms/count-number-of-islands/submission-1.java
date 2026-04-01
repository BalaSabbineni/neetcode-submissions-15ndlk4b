class Solution {
    // understod question clearly
    // we can solve using either BFS or DFS
    // we need to use visited array and need to check all the neighbouring element of each element
    
    /* To check neighbouring element
    we need to check like this, If we are at grid[0][2].
    This means, we are at row 1 and column 2
    now, we need to neighbour element like 
    row[1]+1 = above row of current row which is row[0]
    row[1]-1 = below row  of current row which is row[2]
    col[2]+1 = next coulmn which means col[3]
     col[2]-1 = prev coulmn whcih means col[1] 
    */
    public int numIslands(char[][] grid) {
        int count = 0;

        int row = grid.length;
        int col = grid[0].length;

        // Because of 2D array, we need a pair class to mark about visited nodes.
        
        // like any other 2D array problem, we need to iterate using two loops
        for(int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if(grid[r][c] == '1') {
                    count++; 
                     // dfs 
                     dfs(grid, r, c);
                }
               
               

            }
        }

        return count;   
    }

    private void dfs(char[][] grid, int r, int c) {

        // base check if row and columns are out of index bound
        if(r < 0 || c < 0 || r >= grid.length 
        || c >= grid[r].length ||  grid[r][c] == '0') {
            return;
        }

        // update visited element grid[r][c] as visited by making zero
        grid[r][c] = '0';

        // explore all the directions 
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        
    }
}

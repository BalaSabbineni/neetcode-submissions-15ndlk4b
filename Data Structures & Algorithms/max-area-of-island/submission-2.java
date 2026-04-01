class Solution {
    // this is similar to no of Islands
    // we need to do DFS on each side same like length of tree. and need to count it. 
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea =0;
        // need rows and columns to iterate on 2D array
        int row = grid.length;
        int col = grid[0].length;

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                // check coming element is 1 or not.
                // if 1, we need to check neighbour elements, for that we need  DFS 
                // we meed area, right? So, we need a DFS with int return 
                // which returns area of current DFS
                if(grid[r][c] == 1) {
                    
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
        
    }

    private int dfs(int[][] grid, int r, int c) {

        // base check for neighbour rlement and index bound and element not equla to 0
        if(r<0 || c<0 || r>=grid.length || c>=grid[r].length || grid[r][c] == 0) {
            return 0;
        }
       
        // After base check, coming elemwnt is always 1, so we need to mark as mark as vistied
        grid[r][c] = 0;

        // need a variable to track count of 1's
        // Important, we need intial count value as 1 NOT 0.
        // why becuase, we incrementing only after finding 1.
        int count = 1;

        // dfs and increment count
        count += dfs(grid, r+1, c);
        count += dfs(grid, r-1, c);
        count += dfs(grid, r, c+1);
        count += dfs(grid, r, c-1);
        
        return count;
    }
}

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

    // final result list to store coordinates that reach both oceans
    List<List<Integer>> result = new ArrayList<>();

    // edge case check
    if (heights == null || heights.length == 0 || heights[0].length == 0)
        return result;

    // rows and columns count
    int rows = heights.length;
    int cols = heights[0].length;

    /*
      We need 2 boolean matrices:
      pacific[r][c]  = true means water from (r,c) can reach Pacific ocean
      atlantic[r][c] = true means water from (r,c) can reach Atlantic ocean
    */
    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];

    /*
       KEY IDEA:
       We start DFS from the oceans *towards the land*.
       Because water normally flows DOWNHILL,
       but if we start from the ocean and move to higher or equal cells,
       we find all cells that can eventually flow into that ocean.
    */

    // -----------------------
    // Perform DFS for PACIFIC
    // -----------------------

    // Pacific touches: top row (0, c) and left column (r, 0)

    // iterate on all columns for top row (Pacific)
    for (int c = 0; c < cols; c++) {
        // starting from top row (0, c)
        dfs(heights, pacific, 0, c);

        // starting from bottom row belongs to Atlantic (NOT Pacific)
        dfs(heights, atlantic, rows - 1, c);
    }

    // iterate on all rows for left col (Pacific) and right col (Atlantic)
    for (int r = 0; r < rows; r++) {

        // pacific left side
        dfs(heights, pacific, r, 0);

        // atlantic right side
        dfs(heights, atlantic, r, cols - 1);
    }

    /*
       Now both pacific[][] and atlantic[][] are filled.
       We check for cells that can reach BOTH oceans.
    */
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {

            // if both are true => this cell can reach both oceans
            if (pacific[r][c] && atlantic[r][c]) {
                result.add(Arrays.asList(r, c));
            }
        }
    }

    // finally return the result
    return result;
}



private void dfs(int[][] heights, boolean[][] ocean, int r, int c) {

    // mark this cell visited for current ocean
    ocean[r][c] = true;

    // possible 4 directions (down, up, right, left)
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    int rows = heights.length;
    int cols = heights[0].length;

    // explore all 4 directions
    for (int[] d : dirs) {
        int nr = r + d[0]; // neighbor row
        int nc = c + d[1]; // neighbor col

        /*
           We can DFS into neighbor cell only if:
           1. it's inside the grid
           2. not visited before
           3. heights[nr][nc] >= heights[r][c]  (reverse water flow)
             - meaning water can flow from this neighbor down to here
             - so (nr,nc) can reach the same ocean as (r,c)
        */
        if (nr >= 0 && nc >= 0 &&
            nr < rows && nc < cols &&
            !ocean[nr][nc] &&
            heights[nr][nc] >= heights[r][c]) {

            // recursively DFS the neighbor
            dfs(heights, ocean, nr, nc);
        }
    }
}

}

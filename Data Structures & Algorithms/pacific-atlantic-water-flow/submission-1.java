class Solution {
    // Read and understood question 
    // we need to find the cells that are able to reach to both atlantic and pacific ocean
    // cell can travel all four diretions ONLY cell's height >= to neighbor cell height
    // eg: cell[0,2] height 7 and neighbors are 4,2 and 3,4. all are lesser height than 7.

    // we can solve using DFS
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         List<List<Integer>> result = new ArrayList<>();

         // edge case
         if(heights == null || heights.length == 0 || heights[0].length == 0) return result;

         int rows = heights.length, cols = heights[0].length;

         // we need two boolean matrices. one for pacific ocean and another one for atlantic
         // AND need to get common cells and add to result;
         boolean[][] pacific = new boolean[rows][cols];
         boolean[][] atlantic = new boolean[rows][cols];

         // we need to do DFS and need to add cells that can reach to both oceans

         // first do dfs for pacfific ocean and update pacific boolean array
         /*
         The Key is here, understadning question to do dfs
         pacific ocean is on the top and left sides.
         this means near to top row =0, left col =0; 
         and near to rows-1, col
         we need to pass these tp do dfs
         */
         // we need to iterate on columns lengh why because atlantic is on right

         //For Pacific: top row + left col
         for(int c = 0; c< cols; c++) {
            dfs(heights, pacific, 0,c);
            dfs(heights, atlantic, rows-1,c);
         }

         // Next,  do dfs for atlantic ocean and update pacific boolean array
         /*
         The Key is here, understadning question to do dfs
         atlantic ocean is on the bottow and right sides.
         this means top row = rowsCount -1, right= colsCount - 1; 
         we need to pass these tp do dfs
         */

         for(int r=0; r< rows; r++) {
            dfs(heights, pacific, r,0);
            dfs(heights, atlantic, r, cols-1);
         }


         // check common elements. 
         for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                // this means, cells[i][j] can reach both oceans.
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
         }


         return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c) {
        int rows = heights.length;
        int cols = heights[0].length;

        // marka visted
        ocean[r][c] = true;

       int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

       // for neighbors traversal
       for(int[] d: dirs) {
        int nr = r+d[0];
        int nc = c+d[1];

        if(nr >=0 && nc >=0 && nr<rows && nc < cols 
        && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]
        ) {
            // call recusion on neighbors
             dfs(heights, ocean, nr, nc);
        }

       }


    }
}

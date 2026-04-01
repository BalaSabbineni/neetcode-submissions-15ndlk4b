class Solution {
    public int numIslands(char[][] grid) {
        // usimng BFS
        int count =0;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] neighbors = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // iterate
        for(int r = 0; r<rows; r++) {
            for(int c = 0; c<cols; c++) {

                if(grid[r][c] == '1') {
                    // increase count
                    count++;

                // do bfs to check all the neighbour elements
                // add current r and c to q
                q.add(new int[] {r,c});
                 // make these r and c as 0 to markas visted
                 grid[r][c] ='0';

                 // do bfs
                 while(!q.isEmpty()) {
                    int[] current = q.poll();

                    // iterate on neighbors
                    for(int[] neighbor : neighbors) {

                        // get neighbor rows as nr
                        int nr = current[0]+neighbor[0];
                        // get neighbor coulmns as nc
                        int nc = current[1]+neighbor[1];

                        // check grod with these neighbors and index boundaries

                        if(nr >=0 && nc >=0 && nr<rows && nc < cols && grid[nr][nc]== '1') {
                            q.add(new int[]{nr, nc});
                            // mark as visted
                            grid[nr][nc] ='0';
                        }

                    }

                 }


                }
            }
        }

        return count;

        
    }
}

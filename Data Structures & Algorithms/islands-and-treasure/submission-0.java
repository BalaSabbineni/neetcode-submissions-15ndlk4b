class Solution {
    // need to BFS same like BFS on no of Islands

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] neighbors =  {{1,0}, {-1,0}, {0,1}, {0,-1}};


        for(int r =0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                // if it's a tresure, add it to queue;
                if(grid[r][c] == 0) {
                    q.add(new int[]{r,c});
                }
            }
        }

        // now, in queue we have all the treasure location coordinates
        // Now, iterate over queue and check all the neighbor values.
        while(!q.isEmpty()) {
            // poll from queue
            // this current has row and col loc of treasure
            int[] current = q.poll();

            // now, iterate over neighbors
            for(int[] neighbor : neighbors) {
                int nr = current[0] + neighbor[0];
                int nc = current[1] + neighbor[1];

                // now check neighbor is land cell, if yes, increment by 1
                if(nr >= 0 && nc >= 0 && nr < rows && nc < cols &&
                    grid[nr][nc] == 2147483647) {

                    // update   treasure values   
                    grid[nr][nc] = grid[current[0]][current[1]] +1;

                    // add to queue
                    q.add(new int[] {nr, nc});

                }
            
                
            }
        }

    }
}

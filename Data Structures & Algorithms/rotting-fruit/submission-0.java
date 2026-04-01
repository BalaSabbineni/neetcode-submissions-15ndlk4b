class Solution {
     public int orangesRotting(int[][] grid) {
    int rows = grid.length;
        int cols = grid[0].length;

        // need queue for BFS and neighbor coordinates to check neighbor elements
        // need a 3 size array queue tow for row, col, countOfTime
        Queue<int[]> q = new LinkedList<>(); // eg: a.add(new int[]{r, c, time};
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // we need to two variables to track time and fresh fruits
        int minutes = 0;
        int fresh = 0;


        // add rotten fruit (2) to q with count as zero
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // add rotten fruit coordinates to queue
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c, 0}); // initially times is zero;
                }
                // add total fresh fruits
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // iterate queue BFS
        while (!q.isEmpty()) {
            // pop queue
            int[] current = q.poll();

            int time = current[2]; // this gets time of current rotten

            // iterate over neighbors
            for (int[] neighbor : neighbors) {
                // with these we get neighbor coordinates
                int nr = current[0] + neighbor[0];
                int nc = current[1] + neighbor[1];

                // now check neighbor can be rotten or not. check element is 1 or not.
                // AND base checking for index is in bound or not
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {

                    // KEY, once neighbor is fresh(1), rot the neighbor AND reduce fresh count
                    grid[nr][nc] = 2;
                    fresh--;

                    // now increment time after rotting fresh fruit
                    q.add(new int[]{nr, nc, time + 1});

                    // now get minutes
                    minutes = Math.max(minutes, time + 1);
                }

            }

        }


        return fresh == 0 ? minutes : -1;
        
    }
}

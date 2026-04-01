class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<rows;i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 0) {
                   q.add(new int[]{i, j});
                }
            }
        }

        int[][] neigh = {{-1,0}, {1, 0}, {0,1}, {0,-1}};

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] n: neigh) {
                int nr = cur[0]+n[0];
                int nc = cur[1]+n[1];

                if(nr>=0 && nc >=0 && nr < rows && nc < cols 
                && grid[nr][nc] == 2147483647) {
                    grid[nr][nc] =  grid[cur[0]][cur[1]]+1;
                    q.add(new int[]{nr, nc});

                }
            }
        }
        //System.out.println(neigh);

    } 
}

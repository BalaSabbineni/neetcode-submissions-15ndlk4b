class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         if(matrix.length == 0) return false;

         int l=0;
         int rows = matrix.length;
         int columns = matrix[0].length;

         int r = (rows * columns) - 1;
         System.out.println("r: "+r);

         while(l<=r) {
            int midpoint = l + (r-l)/2;
              System.out.println("midpoint: "+midpoint);
            int row = midpoint/columns;
             System.out.println("row: "+row);
            int column = midpoint%columns;
             System.out.println("column: "+column);
            int midpointValue = matrix[row][column];

            if(midpointValue == target) {
                return true;
            } else if(midpointValue > target) {
                r = midpoint -1;
            } else{
                l = midpoint +1;
            }

         }

         return false;
    }
}

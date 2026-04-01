class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         if (matrix.length == 0) return false;
        int l = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int r = rows * columns - 1;
        System.out.println("r: "+r);

        while (l <= r) {
            int midPointIndex = l + (r - l) / 2;
            int row = midPointIndex / columns;
            int column = midPointIndex % columns;
            int midPointValue = matrix[row][column];
            System.out.println(midPointValue);

            if (midPointValue == target) {
                return true;
            }

            if (midPointValue > target) {
                r = midPointIndex - 1;
            } else {
                l = midPointIndex + 1;
            }
        }

        return false;
    }
}

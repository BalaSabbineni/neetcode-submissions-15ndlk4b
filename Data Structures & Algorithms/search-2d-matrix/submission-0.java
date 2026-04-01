class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         /*
         * Here elements in matrix are sorted. So, we can use binary search algo
         *
         * Here, we have 2D matrix. We can't do same a 1D array.
         * In 2D array, we have multiple rows and multiple columns.
         *
         */

        if (matrix.length == 0) return false;

        // stating point of matrix
        int l = 0;

        int rows = matrix.length;
        int columns = matrix[0].length;
        // ending of matrix. we can't use simply matrix.length - 1; This 2D matrix.
        // to get total no of elements in 2D matrix, we need to use row * columns
        // we are using indexes, so we need to use -1 for r =  row * column -1;
        int r = rows * columns - 1;
        while (l <= r) {
            int midpoint = l + (r - l) / 2;

            // this is formula for calculating index postion. In 1D array we can directly get index value.
            // but for we 2D array, we need to use like this
            // why because to get target, we will get like matrix[2][3] == target number
            // for 1D, matrix[3] == target
            int row = midpoint / columns;
            int column = midpoint % columns;

            //now we can get mid value of matrix
            int midValue = matrix[row][column];

            if (midValue == target) {
                return true;

            } else if (midValue > target) {
                r = midpoint - 1;

            } else {
                l = midpoint + 1;

            }

        }

        return false;
    }
}

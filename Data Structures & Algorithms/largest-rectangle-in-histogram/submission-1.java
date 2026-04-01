class Solution {
    public int largestRectangleArea(int[] heights) {
       // we need to find which bars can form rectangle with large area
//         we can extend bars to left or right, but key is only lower or equal height makes rectangle.
//         e.g: take these heights [7,1,7,2,2,4]: first one h = 7, we can't extend to right why because next bar height is 1.
//         it won't form rectangle.
//         now take height 2, indext at 3, you can extend upto last index and also before index i.e index 2 with height 7
//         now calculate area = w*h
        /*
         * we need to use stack for it and need to store indicies
         *
         * for suppose, take this  example: [7,1,7,2,2,4]
         * first index height is 7, and width is 1. This is the 1st element, so we will add to stack.
         *
         * In next index,  the key is height. If index one height is less than index O, then index 0 can't extend further.
         * So, we need a check like this. If new incoming index height < existing one, we can extend towards left.
         * so, index 0 can't extend further, so we will pop out from stack. and get value of the poped window for height
         * so,we can calulate height and width and pop out the stack elemnt
         * Next, if stack is not empty, then we cal width like this i -stack.peek -1
         *
         */


        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            // case to check last element
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);

            }

            stack.push(i);
        }
        return maxArea;


    }

}

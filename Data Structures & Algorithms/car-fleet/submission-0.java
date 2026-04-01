class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
    // first we need to calculate time for each car time = distance(target-position)/speed
        // we need to sort the arrays in decreasing order and then calculate time.
        // If time is less than or qual to first car, one fleet. If  time is greater than  first car, another fleet.

        // To sort array based on another array(position and speed based on each other), we can use 2D array
        int[][] res = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            res[i] = new int[]{position[i], speed[i]};
        }
 Arrays.sort(res, (a, b) -> Integer.compare(b[0], a[0]));        System.out.println(Arrays.deepToString(res));

        Stack<Double> stack = new Stack<>();

        for (int[] pair : res) {
           stack.push((double) (target - pair[0]) / pair[1]);

            // Now, we need to check after adding 2nd car time to the stack and
            // the 2nd car time is less than first car or not.if yes, we need to pop it.

            // To check after adding 2nd car time to the stack - we just need to check stack size like this stack.size() >= 2
            // 2nd check is is stack.peek() <= stack.get(stack.size() - 2))
            // what this do is simple, stack.peek() value is newly added car's speed. To get previous car we just need to use
            // stack.get(stack.size() - 2)) and check time is less or not.
            // If less, it will one one fleet. so, pop it out
            if (stack.size() >= 2 &&
                    stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
        
    }
}

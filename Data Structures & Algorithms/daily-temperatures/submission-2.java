class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
      // we can solve this problem using brute force, but time complexity is very high. Stack is best one

        /*
         * First, If stack is empty we need element from arr[] to stack. We need to store indices, not values.
         *
         * then If stack is not empty, then we need to check existing index value i.e., stack peek's temperature is  < incoming index( tem[i])
         * if true, then we can add our result to result array.
         *
         * Here This is important, we need to add to result by using stack peek value not current i value.
         * value will be current index and peek difference.
         *
         * why because, In stack we are storing indexes and then checking temperature of new i is greater or not.
         * If yes, last element i.e, stack peek , we found greater temp.
         * then we need to pop out, we found difference
         *
         *
         *
         */


        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();

            }
            stack.push(i);
        }

        return result;
    }
}

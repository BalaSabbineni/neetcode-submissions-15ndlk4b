class MinStack {

    /*
         * For this we need to use two stack approach  (stack1, minStack) and track min values in separate stack and current values on first stack.
         *
         * If we are adding any element to stack1, we need to check that is lower element in minStack or not. if yes, we need to add minStack.
         * There is edge case here, For first add, minStack can be empty so, we need to check minStack is empty ot val <= minStack.value

         * If we are removing any element, need to check that element is minStack element or not. If yes, we need to remove from minStack also.
         *
         * Rest all simple operations
         */

        Stack<Integer> stack;
        Stack<Integer> minStack;


        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) { // here we are adding
            stack.push(val);

            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            int poppedValue = stack.pop();

            if (poppedValue == minStack.peek()) {
                minStack.pop();

            }

        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return minStack.peek();

        }

}
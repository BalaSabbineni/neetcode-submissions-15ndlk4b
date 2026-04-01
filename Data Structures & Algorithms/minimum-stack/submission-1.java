class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> minStack; 

    public MinStack() {
        stack1 = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
            stack1.push(val);

            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }

        }

        public void pop() {
            int val = stack1.pop();
            if(val == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack1.peek();

        }

        public int getMin() {
            return minStack.peek();
        }
}

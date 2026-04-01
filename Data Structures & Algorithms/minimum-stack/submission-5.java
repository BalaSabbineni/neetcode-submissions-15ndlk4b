class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        st.push(val);

        if (minSt.isEmpty() || minSt.peek() >= val) {
            minSt.push(val);
        } 
    }

    public void pop() {
        int val = st.pop();

        if (!minSt.isEmpty() && val == minSt.peek()) {
            minSt.pop();
        }

    }

    public int top() {
        return st.isEmpty() ? 0 : st.peek();

    }

    public int getMin() {
        return minSt.isEmpty() ? 0 : minSt.peek();
    }
}


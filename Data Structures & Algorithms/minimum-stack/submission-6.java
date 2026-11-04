class MinStack {
    int min;
    Stack<Integer> stack = null;
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min)
        {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min == stack.peek())
        {
            stack.pop();
            min = stack.pop();
        }else
        {
            stack.pop();
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

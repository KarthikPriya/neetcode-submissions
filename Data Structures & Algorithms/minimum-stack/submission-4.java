class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<int[]>();
    }
    
    public void push(int val) {
        if(!stack.isEmpty())
        {
            int[] top = stack.peek();
            if(val < top[1])
                stack.push(new int[]{val, val});
            else
                stack.push(new int[]{val, top[1]});
        }else
            stack.push(new int[]{val, val});
    }
    
    public void pop() {
        if(!stack.isEmpty())
            stack.pop();
    }
    
    public int top() {
        int[] top = new int[]{};
        if(!stack.isEmpty())
        {
            top = stack.peek();
        }
        return top[0];
    }
    
    public int getMin() {
        int[] top = new int[]{};
        if(!stack.isEmpty())
        {
            top = stack.peek();
        }
        return top[1];
    }
}

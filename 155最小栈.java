class MinStack {
    Stack<Integer> stk=null;
    Stack<Integer> minStk=null;

    public MinStack() {
        stk=new Stack<>();
        minStk=new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.isEmpty()||minStk.peek()>=val)
            minStk.push(val);
    }
    
    public void pop() {
        if(stk.peek().equals(minStk.peek()))
            minStk.pop();
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
class MinStack {
    LinkedList<Integer>data=new LinkedList<>();
    LinkedList<Integer>min=new LinkedList<>();
    public MinStack() {
        data=new LinkedList<>();
        min=new LinkedList<>();
    }
    
    public void push(int val) {
        data.addFirst(val);
        if(min.size() == 0) {
            min.addFirst(val);
        } else if(val <= min.peek()) {
            min.addFirst(val);
        }
    }
    
    public void pop() {
        int val=data.removeFirst();
        if(min.size()>0 &&  min.peek().equals(val)){
            min.removeFirst();
            
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.size()>0?min.peek():0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
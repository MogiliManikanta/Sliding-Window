class Pair{
    int first;
    int second;
    Pair(int first,int second) {
        this.first=first;
        this.second=second;
    }
}
class MinStack {
    Stack<Pair>stack;
    int mini = (int)1e9;
    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int val) {
      if(stack.isEmpty()){
            stack.push(new Pair(val,val));
            mini=val;
      }
      else{
        mini = Math.min(val,stack.peek().second);
        stack.push(new Pair(val,mini));
      }   
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first;
    }
    
    public int getMin() {
        return stack.peek().second;
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
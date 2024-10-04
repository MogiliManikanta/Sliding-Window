class MinStack {
    Stack<Long>stack;
    Long mini = Long.MAX_VALUE;

    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
        long value = val;
        if(stack.isEmpty()) {
            stack.push(value);
            mini=value;
        }
        else{
            if(value>mini) {
                stack.push(value);
            }
            else{
                long newVal = 2 * value - mini;
                stack.push(newVal);
                mini=value;
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long popElement = stack.pop();
        if(popElement<mini){
            mini = 2 * mini - popElement;
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        long element = stack.peek();
        if(element<mini) {
            return mini.intValue();
        }
        // return element.intValue();
        return (int) element;  // Cast long to int
    }
    
    public int getMin() {
        return mini.intValue();
    }
}


 /***
 
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
  */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1+op2);
            }
            else if(s.equals("*")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1*op2);
            }
            else if(s.equals("-")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1-op2);
            }
            else if(s.equals("/")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1/op2);
            }
            else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
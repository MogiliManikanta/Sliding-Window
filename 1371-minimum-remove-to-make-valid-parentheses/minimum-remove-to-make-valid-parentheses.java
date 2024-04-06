class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else if(c==')'){
                if(stack.size()>0 && s.charAt(stack.peek())=='('){
                    stack.pop();
                }
                else{
                    stack.push(i);
                }
            }
            /*else{
                continue;
            }*/
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while(stack.size()>0){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}
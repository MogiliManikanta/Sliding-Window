class Solution {
    public int calculate(String s) {
        int sum =0;
        int sign=1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    val = val*10 + s.charAt(i)-'0';
                    i++;
                }
                i--;
                val*=sign;
                sign=1;
                sum+=val;
            }
            else if(s.charAt(i)=='('){
                stack.push(sum);
                stack.push(sign);
                sum=0;
                sign=1;
            }
            else if(s.charAt(i)==')'){
                sum*=stack.pop();
                sum+=stack.pop();
            }
            else if(s.charAt(i)=='-'){
                sign=-1;
            }
        }
        return sum;
    }
}
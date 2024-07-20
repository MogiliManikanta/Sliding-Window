class Solution {
    public String removeKdigits(String s, int k) {
        int size = s.length();
        if(size == k) return "0";
        int count = 0;
        Stack<Character>st = new Stack();
        while(count < size){
            while(k>0 && !st.isEmpty() && st.peek()>s.charAt(count)){
                st.pop();
                k--;
            }
            st.push(s.charAt(count));
            count++;
        }
        //edge case handle -> repeating string 1111
        while(k-->0){
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char cur = st.pop();
            sb.append(cur);
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){ //remove leading zeroes
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
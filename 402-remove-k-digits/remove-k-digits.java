class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) return "0"; // If k is greater than or equal to length, return "0"
        
        Stack<Character> stack = new Stack<>();
        
        // Build the smallest possible number using stack
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        // If there are still digits to remove, remove from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Build the final number
        StringBuilder rev = new StringBuilder();
        while (!stack.isEmpty()) {
            rev.append(stack.pop());
        }
        
        // Reverse the result to get the correct order
        rev.reverse();
        
        // Remove leading zeros
        while (rev.length() > 0 && rev.charAt(0) == '0') {
            rev.deleteCharAt(0);
        }
        
        // If the string is empty, return "0"
        return rev.length() == 0 ? "0" : rev.toString();
    }
}

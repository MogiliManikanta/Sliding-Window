class Solution {
    public int longestValidParentheses(String s) {
        // Create a stack to keep track of the indices of characters in the input string
        Stack<Integer> stack = new Stack<>();
        // Push an initial -1 onto the stack to serve as a starting point
        stack.push(-1);
        // Initialize a variable to store the maximum length of valid parentheses substring
        int maxL = 0;

        // Loop through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // Get the index of the character at the top of the stack
            int t = stack.peek();
            
            // Check if the current character is a closing parenthesis ')' and the character at
            // the top of the stack is an opening parenthesis '('
            if (t != -1 && s.charAt(i) == ')' && s.charAt(t) == '(') {
                // Pop the top element from the stack since it's been matched with the current ')'
                stack.pop();
                // Calculate the length of the current valid parentheses substring
                // by subtracting the index of the previous unmatched '(' from the current index
                maxL = Math.max(maxL, i - stack.peek());
            } else {
                // If the conditions are not met, push the current index onto the stack
                // This represents a potentially unmatched character
                stack.push(i);
            }
        }
        
        // Return the maximum length of a valid parentheses substring
        return maxL;
    }
}

/**In the Java code, we use the Stack class from the java.util package, which is similar to the C++ stack data structure. The rest of the code is a straightforward translation of the C++ code to Java syntax.*/

/**Here's a step-by-step explanation of how this code works:

We create a Stack named stack to keep track of the indices of characters in the input string s.

We push an initial value of -1 onto the stack. This -1 serves as a starting point and will help us calculate the length of valid parentheses substrings.

We initialize a variable maxL to store the maximum length of valid parentheses substrings. This variable is initially set to 0.

We iterate through each character in the input string s using a for loop.

Inside the loop, we use the peek() method to get the index of the character at the top of the stack (without removing it) and store it in the variable t.

We check if the current character is a closing parenthesis ) and if the character at index t on the stack is an opening parenthesis (. If both conditions are met, it means we have a valid pair of parentheses.

If we have a valid pair, we pop the top element from the stack since it has been matched with the current ). Then, we calculate the length of the current valid parentheses substring by subtracting the index of the previous unmatched '(' (the new top element of the stack) from the current index i. We use Math.max to update the maxL variable with the maximum length found so far.

If the conditions in step 6 are not met, it means the current character is either an unmatched ( or any other character. In this case, we push the current index i onto the stack, representing a potentially unmatched character.

After processing all characters in the input string, we return the maxL, which represents the maximum length of a valid parentheses substring.

This algorithm effectively finds the length of the longest valid parentheses substring in the input string s using a stack-based approach. */
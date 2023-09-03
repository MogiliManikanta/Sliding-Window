class Solution {
    public int calculate(String s) {
        // Initialize variables to keep track of the result and the current sign.
        int sum = 0;
        int sign = 1;

        // Create a stack to handle parentheses and signs.
        Stack<Integer> stack = new Stack<>();

        // Iterate through the characters in the input string 's'.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // If the character is a digit, parse the whole number.
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + s.charAt(i) - '0'; // Convert char to int
                    i++;
                }
                i--; // Decrement 'i' to account for the last digit.

                // Apply the current sign and add the value to the result.
                val *= sign;
                sign = 1; // Reset sign to positive.
                sum += val;
            }
            else if (ch == '(') {
                // If an opening parenthesis is encountered, push the current sum
                // and sign onto the stack and reset sum and sign for the subexpression.
                stack.push(sum);
                stack.push(sign);
                sum = 0; // Reset sum for the subexpression.
                sign = 1; // Reset sign for the subexpression.
            }
            else if (ch == ')') {
                // If a closing parenthesis is encountered, calculate the result for
                // the subexpression within the parentheses.
                sum *= stack.pop(); // Apply the sign.
                sum += stack.pop(); // Add the result of the previous part of the expression.
            }
            else if (ch == '-') {
                // If a minus sign is encountered, update the sign for the next numbers.
                sign = -1;
            }
        }

        // The 'sum' variable now contains the final result of the expression.
        return sum;
    }
}
/**It iterates through the characters of the input string 's'.
When it encounters a digit, it parses the entire number, considering the sign.
When an opening parenthesis '(' is encountered, it pushes the current sum and sign onto the stack and resets sum and sign for the subexpression.
When a closing parenthesis ')' is encountered, it calculates the result for the subexpression within the parentheses.
If a minus sign '-' is encountered, it updates the sign for the next numbers.
Finally, it returns the accumulated 'sum' as the result of the expression.
This code effectively evaluates arithmetic expressions that include addition, subtraction, and parentheses. */
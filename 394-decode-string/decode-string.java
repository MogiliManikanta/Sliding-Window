public class Solution {
    public String decodeString(String s) {
        // Initialize an empty string to store the result.
        String res = "";

        // Create two stacks: one for counting and one for intermediate results.
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        // Initialize an index variable to traverse the input string 's'.
        int idx = 0;

        // Start processing the input string character by character.
        while (idx < s.length()) {
            // If the current character is a digit, it indicates a count.
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                // Continue reading digits to construct the count value.
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                // Push the count onto the countStack.
                countStack.push(count);
            }
            // If the current character is an opening bracket '[',
            // push the current 'res' (substring) onto the resStack
            // and reset 'res' to an empty string.
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            // If the current character is a closing bracket ']',
            // it's time to decode the substring inside the brackets.
            else if (s.charAt(idx) == ']') {
                // Pop the previous result from resStack and
                // construct the repeated substring.
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res); // Append the current 'res'.
                }
                // Update 'res' with the decoded substring.
                res = temp.toString();
                idx++;
            }
            // If the current character is neither a digit nor a bracket,
            // simply append it to the 'res' string.
            else {
                res += s.charAt(idx++);
            }
        }
        // After processing the entire string, 'res' will contain the decoded result.
        return res;
    }
}
/**Certainly! The given Java code is an implementation of a string decoding algorithm. It takes an encoded string as input and returns the decoded string. The encoding follows a specific pattern: [count]substring, where count represents the number of times the substring should be repeated. Here's a step-by-step explanation of the code with comments: */



/**Initialize res to an empty string to store the result, and create two stacks: countStack to keep track of counts and resStack to store intermediate results.

Start iterating through the input string s using the idx index variable.

Inside the loop, check the current character:

If it's a digit, build the count by reading consecutive digits and push it onto the countStack.
If it's an opening bracket '[', push the current res onto the resStack and reset res to an empty string to prepare for the next substring.
If it's a closing bracket ']', pop the previous result from resStack, repeat the current res as many times as specified by the count on countStack, and update res with the decoded substring.
If it's neither a digit nor a bracket, simply append it to the res string.
After processing the entire string, the decoded result will be stored in the res variable, so return it.

This code effectively decodes strings that follow the specified pattern, such as "3[a]2[bc]" would be decoded to "aaabcbc". */
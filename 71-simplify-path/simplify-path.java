import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        // Create a stack to store directory and file names.
        Stack<String> stack = new Stack<>();
        // Create a StringBuilder to build the result string efficiently.
        StringBuilder res = new StringBuilder();

        // Loop through each character in the input 'path' string.
        for (int i = 0; i < path.length(); ++i) {
            // Skip leading '/' characters.
            if (path.charAt(i) == '/') {
                continue;
            }
            // Create a StringBuilder 'temp' to store the current directory or file name.
            StringBuilder temp = new StringBuilder();
            
            // Iterate until we reach the end of the string or encounter a '/' character.
            while (i < path.length() && path.charAt(i) != '/') {
                // Add the character to the 'temp' string.
                temp.append(path.charAt(i));
                ++i;
            }
            
            // Check if the 'temp' string represents the current directory ('.').
            if (temp.toString().equals(".")) {
                // Skip current directory reference.
                continue;
            } else if (temp.toString().equals("..")) {
                // Check if the 'temp' string represents the parent directory ('..').
                // If so, and if the stack is not empty, pop the top element (move up one level).
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // If the 'temp' string is a valid directory or file name,
                // push it onto the stack.
                stack.push(temp.toString());
            }
        }

        // Build the result string by popping elements from the stack and inserting them at the beginning.
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }

        // If no directory or file is present, return a single '/'.
        if (res.length() == 0) {
            return "/";
        }

        // Convert the StringBuilder 'res' to a string and return the simplified path.
        return res.toString();
    }
}

/**We create a Stack named stack to store directory and file names. This stack will help us keep track of the simplified path.

We create a StringBuilder named res to efficiently build the result string.

We iterate through each character in the input path string.

We skip leading '/' characters by checking if the current character is '/' and continue to the next character if it is.

We create a StringBuilder named temp to store the current directory or file name.

We iterate until we reach the end of the string or encounter a '/' character. During this iteration, we append characters to the temp string, effectively capturing the directory or file name.

We check if the temp string represents the current directory (".") and skip it if so.

If the temp string represents the parent directory (".."), we check if the stack is not empty. If it's not empty, we pop the top element from the stack, simulating moving up one level in the directory hierarchy.

If the temp string is a valid directory or file name, we push it onto the stack.

After processing all directory and file names, we build the result string by popping elements from the stack and inserting them at the beginning of the res StringBuilder. This ensures that the elements are in the correct order in the final path.

If no directory or file is present (i.e., the res StringBuilder is empty), we return a single '/'.

Finally, we convert the StringBuilder res to a string using toString() and return the simplified path.

This code effectively simplifies a given file path by resolving '..', '.', and '/' references. It returns the simplified path as a string. */
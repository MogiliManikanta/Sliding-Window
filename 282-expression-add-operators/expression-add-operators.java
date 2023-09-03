class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        // Initialize the result list and start the depth-first search (DFS).
        dfs(0, "", 0, 0, num, target);
        return result;
    }

    private void dfs(int i, String path, long resSoFar, long prevNum, String s, int target) {
        // If we have processed all characters in the input string 's', check if the
        // accumulated result equals the target value and add the path to the result list.
        if (i == s.length()) {
            if (resSoFar == target) {
                result.add(path);
                return;
            }
        }

        // Loop through the characters in the input string starting from index 'i'.
        for (int j = i; j < s.length(); j++) {
            // Handle cases where there are leading zeros by breaking the loop.
            if (j > i && s.charAt(i) == '0') {
                break;
            }

            // Extract the current number from the substring.
            long currNum = Long.parseLong(s.substring(i, j + 1));

            // Recursive calls for different operator combinations.
            if (i == 0) {
                // If this is the first number, we don't need an operator.
                dfs(j + 1, path + currNum, currNum, currNum, s, target);
            } else {
                // Try addition, subtraction, and multiplication with the current number.
                dfs(j + 1, path + "+" + currNum, resSoFar + currNum, currNum, s, target);
                dfs(j + 1, path + "-" + currNum, resSoFar - currNum, -currNum, s, target);
                dfs(j + 1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum, s, target);
            }
        }
    }
}
/**The addOperators function initializes an empty result list and starts the depth-first search (DFS) by calling the dfs function with initial parameters.

The dfs function takes several parameters:

i: The current index in the input string 's'.
path: The current expression being built.
resSoFar: The result accumulated so far.
prevNum: The previous number encountered in the expression.
s: The original input string.
target: The target value to reach.
Within the dfs function, it first checks if we have processed all characters in 's'. If so, it checks if the accumulated result (resSoFar) equals the target value. If it does, it adds the current expression (path) to the result list.

The code then iterates through the characters in 's' starting from the current index 'i'. It handles cases where there might be leading zeros by breaking the loop.

For each valid substring (representing a number), it converts it to a long integer (currNum) and makes recursive calls with different operators ('+', '-', and '*') to explore all possible combinations of operators for the current number.

The recursion continues, and as the algorithm explores different combinations, it eventually builds valid expressions that may or may not equal the target value. Valid expressions are added to the result list.

Finally, the addOperators function returns the result list containing all valid expressions that result in the target value.
 */
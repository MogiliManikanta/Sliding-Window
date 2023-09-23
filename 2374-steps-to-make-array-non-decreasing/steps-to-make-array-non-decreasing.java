class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length; // Get the length of the input array 'nums'
        Stack<Pair<Integer, Integer>> stack = new Stack<>(); // Create a stack to store pairs (value, steps)
        stack.push(new Pair(nums[n - 1], 0)); // Push the last element and 0 steps onto the stack
        int ans = 0; // Initialize the answer variable to 0

        // Loop through the elements in 'nums' from right to left
        for (int i = n - 2; i >= 0; i--) {
            int count = 0; // Initialize a count variable to 0

            // While the stack is not empty and the current element 'nums[i]' is greater than the top element of the stack
            while (!stack.isEmpty() && nums[i] > stack.peek().getKey()) {
                // Calculate the new count as the maximum of the current count + 1 and the count of the top element of the stack
                count = Math.max(count + 1, stack.peek().getValue());
                stack.pop(); // Pop the top element from the stack
            }

            ans = Math.max(ans, count); // Update the answer by taking the maximum of the current answer and the count
            stack.push(new Pair(nums[i], count)); // Push the current element and the count onto the stack
        }

        return ans; // Return the final answer
    }
}

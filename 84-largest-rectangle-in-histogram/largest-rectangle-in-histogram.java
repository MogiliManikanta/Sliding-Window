class Solution {
    public int largestRectangleArea(int[] heights) {
        // Initialize a variable to keep track of the maximum area.
        int maxArea = Integer.MIN_VALUE;
        
        // Get the length of the input array.
        int n = heights.length;
        
        // Create a stack to store the indices of the heights in ascending order.
        Stack<Integer> stack = new Stack<>();
        
        // Loop through each height and consider an extra iteration with height = 0.
        for (int i = 0; i <= n; i++) {
            // While the stack is not empty and the current height is less than or equal
            // to the height at the index stored in the stack, calculate the area for the
            // height at the top of the stack.
            while (!stack.isEmpty() && (i == n || heights[i] <= heights[stack.peek()])) {
                // Get the height at the top of the stack.
                int height = heights[stack.pop()];
                
                // Calculate the width of the rectangle using the difference between
                // the current index 'i' and the index at the top of the stack.
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                
                // Calculate the area for the current rectangle and update maxArea if needed.
                maxArea = Math.max(maxArea, width * height);
            }
            
            // Push the current index 'i' onto the stack.
            stack.push(i);
        }
        
        // Return the maximum area found.
        return maxArea;
    }
}

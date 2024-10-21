class Solution {

    // Main function to calculate the difference between sum of subarray maximums and minimums
    public long subArrayRanges(int[] nums) {
        // Returns the difference between total sum of subarray maximums and minimums
        return sumOfSubArrayMaximum(nums) - sumOfSubArrayMinimum(nums);
    }

    // Function to calculate the sum of all subarray maximums
    public long sumOfSubArrayMaximum(int[] nums){
        int[] nge = nextGreaterNumber(nums); // Array of indices for the next greater element
        int[] pge = previousGreaterNumber(nums); // Array of indices for the previous greater element
        long result = 0;

        // Loop through each element to calculate its contribution to all subarray maximums
        for(int i = 0; i < nums.length; i++){
            // Number of elements to the left that nums[i] is the max for
            long leftIndex = i - pge[i]; 
            // Number of elements to the right that nums[i] is the max for
            long rightIndex = nge[i] - i;
            // Each element's contribution is based on the subarrays it is a maximum in
            result = result + (leftIndex * rightIndex * nums[i] * 1L); // Multiply by nums[i] as max
        }
        return result; // Return the total sum of subarray maximums
    }

    // Helper function to find indices of the next greater element for each element
    public int[] nextGreaterNumber(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left to find the next greater element
        for(int i = n - 1; i >= 0; i--){
            // Pop elements from the stack while they are smaller than or equal to current element
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop(); 
            }
            // If stack is empty, no greater element, so store `n`, otherwise store index of next greater
            result[i] = stack.isEmpty() ? n : stack.peek(); 
            // Push the current index onto the stack
            stack.push(i); 
        }
        return result; // Return the array of next greater element indices
    }

    // Helper function to find indices of the previous greater element for each element
    public int[] previousGreaterNumber(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        // Traverse the array from left to right to find the previous greater element
        for(int i = 0; i < n; i++){
            // Pop elements from the stack while they are smaller than the current element
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            // If stack is empty, no previous greater element, so store `-1`, otherwise store index
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current index onto the stack
            stack.push(i); 
        }
        return result; // Return the array of previous greater element indices
    }

    // Function to calculate the sum of all subarray minimums
    public long sumOfSubArrayMinimum(int[] nums){
        int[] pse = previousSmallerNumber(nums); // Array of indices for the previous smaller element
        int[] nse = nextSmallerNumber(nums); // Array of indices for the next smaller element
        long result = 0;

        // Loop through each element to calculate its contribution to all subarray minimums
        for(int i = 0; i < nums.length; i++){
            // Number of elements to the left that nums[i] is the min for
            long leftIndex = i - pse[i];
            // Number of elements to the right that nums[i] is the min for
            long rightIndex = nse[i] - i;
            // Each element's contribution is based on the subarrays it is a minimum in
            result = result + (leftIndex * rightIndex * nums[i] * 1L); // Multiply by nums[i] as min
        }
        return result; // Return the total sum of subarray minimums
    }

    // Helper function to find indices of the previous smaller element for each element
    public int[] previousSmallerNumber(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from left to right to find the previous smaller element
        for(int i = 0; i < n; i++){
            // Pop elements from the stack while they are greater than the current element
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop(); 
            }
            // If stack is empty, no previous smaller element, so store `-1`, otherwise store index
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current index onto the stack
            stack.push(i);
        }
        return result; // Return the array of previous smaller element indices
    }

    // Helper function to find indices of the next smaller element for each element
    public int[] nextSmallerNumber(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left to find the next smaller element
        for(int i = n - 1; i >= 0; i--){
            // Pop elements from the stack while they are greater than or equal to the current element
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop(); 
            }
            // If stack is empty, no smaller element, so store `n`, otherwise store index of next smaller
            result[i] = stack.isEmpty() ? n : stack.peek();
            // Push the current index onto the stack
            stack.push(i);
        }
        return result; // Return the array of next smaller element indices
    }
}

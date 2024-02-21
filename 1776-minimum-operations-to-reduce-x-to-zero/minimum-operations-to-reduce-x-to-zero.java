class Solution {
    public int minOperations(int[] nums, int x) {
        // Initialize the target value to find
        int target = -x;
        
        // Calculate the total sum of the nums array
        for (int i : nums) {
            target += i;
        }
        
        // If the target sum is negative, it means it's not possible to achieve the target
        if (target < 0) {
            return -1;
        }
        
        // Initialize result to track the length of the subarray that sums up to the target
        int result = -1;
        
        // Initialize sum to keep track of the current sum of elements
        int sum = 0;
        
        // Length of the nums array
        int n = nums.length;
        
        // Initialize left pointer for sliding window technique
        int left = 0;
        
        // Loop through the nums array
        for (int i = 0; i < n; i++) {
            // Add the current element to the sum
            sum += nums[i];
            
            // If the sum exceeds the target
            if (sum > target) {
                // Slide the window by moving the left pointer until sum becomes less than or equal to target
                while (sum > target) {
                    sum -= nums[left]; // Subtract the element pointed by the left pointer
                    left++; // Move the left pointer to the right
                }
            }
            
            // If the sum equals the target, update the result
            if (sum == target) {
                result = Math.max(result, i - left + 1); // Update result with the length of the subarray
            }
        }
        
        // If result is still -1, it means no subarray sums up to the target
        // Otherwise, return the length of the subarray that sums up to the target
        return result == -1 ? -1 : n - result;
    }
}

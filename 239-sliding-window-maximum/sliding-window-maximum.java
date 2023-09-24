class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {		
        // Check for edge cases
        if (nums == null || k <= 0) {
            return new int[0]; // If the input is invalid, return an empty array
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Initialize the result array to store maximum values
        int resultIndex = 0;
        
        // Create a deque (double-ended queue) to store the indices of elements in the sliding window
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // Remove numbers from the front of the deque that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < currentIndex - k + 1) {
                deque.pollFirst();
            }
            
            // Remove smaller numbers from the back of the deque as they are not needed for maximum calculation
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[currentIndex]) {
                deque.pollLast();
            }
            
            // Add the current index to the deque
            deque.offer(currentIndex);
            
            // If the current index is within the first valid window (k-1 or more elements in the window),
            // add the maximum value in the current window to the result array
            if (currentIndex >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        
        return result; // Return the array containing maximum values in each sliding window
    }
}
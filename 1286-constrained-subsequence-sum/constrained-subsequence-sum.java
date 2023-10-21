class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
    // Initialize the maximum sum variable to the first element of the input array.
    int maxSum = nums[0];
    
    // Create a deque (double-ended queue) to store potential maximum subsequence sums.
    Deque<Integer> maxSumQueue = new ArrayDeque<>();
    
    // Iterate through the input array.
    for (int i = 0; i < nums.length; ++i) {
        // Update the current element in the array by adding the maximum sum from the queue
        // (if the queue is not empty). This step essentially keeps track of the maximum
        // sum of a subsequence ending at the current element.
        nums[i] += !maxSumQueue.isEmpty() ? maxSumQueue.peek() : 0;
        
        // Update the overall maximum sum found so far.
        maxSum = Math.max(maxSum, nums[i]);
        
        // Remove elements from the end of the queue (right side) that are less than the
        // current element in the array. This is because any subsequence ending with those
        // smaller elements cannot contribute to a maximum sum.
        while (!maxSumQueue.isEmpty() && nums[i] > maxSumQueue.peekLast()) {
            maxSumQueue.pollLast();
        }
        
        // If the current element in the array is positive, add it to the queue because it
        // could potentially contribute to a maximum subsequence sum in the future.
        if (nums[i] > 0) {
            maxSumQueue.offer(nums[i]);
        }
        
        // If we have processed k elements and the front of the queue (left side) is
        // the same as the element that was k positions behind the current element,
        // remove it from the queue. This is to ensure that we only consider elements
        // within the constraint of at most k elements in the subsequence.
        if (i >= k && !maxSumQueue.isEmpty() && maxSumQueue.peek() == nums[i - k]) {
            maxSumQueue.poll();
        }
    }
    
    // Return the maximum sum found in the entire array.
    return maxSum;
}
}
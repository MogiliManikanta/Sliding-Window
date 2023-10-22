class Solution {
    public int maximumScore(int[] nums, int k) {
    int result = nums[k]; // Initialize the result with the value at index k
    int minVal = nums[k]; // Initialize the minimum value found so far
    int leftPointer = k; // Initialize a left pointer
    int rightPointer = k; // Initialize a right pointer
    int length = nums.length; // Get the length of the array

    // Continue iterating as long as there are elements to the left or right
    while (leftPointer > 0 || rightPointer < length - 1) {
        if (leftPointer == 0) {
            ++rightPointer; // Move the right pointer to the right
        } else if (rightPointer == length - 1) {
            --leftPointer; // Move the left pointer to the left
        } else if (nums[leftPointer - 1] < nums[rightPointer + 1]) {
            ++rightPointer; // Move the right pointer to the right
        } else {
            --leftPointer; // Move the left pointer to the left
        }

        // Update the minimum value with the minimum of the current left and right values
        minVal = Math.min(minVal, Math.min(nums[leftPointer], nums[rightPointer]));

        // Calculate the current score and update the result if it's greater
        result = Math.max(result, minVal * (rightPointer - leftPointer + 1));
    }

    return result; // Return the maximum score
}
}
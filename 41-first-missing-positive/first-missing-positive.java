class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length; // Get the length of the input array.

        // First, we perform a rearrangement of the array to put positive integers in their
        // correct positions (e.g., 1 should be at index 0, 2 at index 1, etc.).

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                continue; // Skip non-positive numbers and numbers greater than n.
            }
            int chair = nums[i] - 1; // Calculate the target index for the current element.

            if (nums[i] != nums[chair]) {
                // Swap the current element with the element at the target index (chair).
                int temp = nums[i];
                nums[i] = nums[chair];
                nums[chair] = temp;

                i--; // Important term: This is used to recheck the swapped element.
                // After swapping, we recheck the current index since the newly swapped
                // element may also need to be rearranged.
            }
        }

        // After the rearrangement, the array should now be in a state where nums[i] == i+1
        // for each index i. If that's not the case, it means the first missing positive
        // integer is missing at index i.

        for (int i = 0; i < n; i++) {
            if (i + 1 == nums[i]) {
                continue; // If the element is in its correct position, move to the next index.
            } else {
                return i + 1; // If the element is not in its correct position, return i+1.
            }
        }

        // If all elements are in their correct positions, then the first missing positive
        // integer is n + 1 (one more than the length of the array).
        return n + 1;
    }
}

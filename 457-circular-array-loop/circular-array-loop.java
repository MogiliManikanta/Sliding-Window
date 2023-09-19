class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            int slow, fast;
            slow = i;
            fast = i;
            // Determine the direction of movement based on the element's sign
            boolean iForward = nums[i] >= 0;
            while (true) {
                // Move the slow and fast pointers
                slow = getNextIndex(nums, slow, iForward);
                if (slow == -1) {
                    break;
                }
                fast = getNextIndex(nums, fast, iForward);
                if (fast == -1) {
                    break;
                }
                fast = getNextIndex(nums, fast, iForward);
                if (fast == -1) {
                    break;
                }
                // If a loop is found (fast pointer meets slow pointer), return true
                if (fast == slow) {
                    return true;
                }
            }
        }
        // No circular loop found in the array
        return false;
    }

    // Helper function to get the next index to move to
    private int getNextIndex(int[] nums, int index, boolean iForward) {
        // Determine the direction of movement based on the element's sign
        boolean direction = nums[index] >= 0;
        // If the direction doesn't match the initial direction, return -1
        if (iForward != direction) {
            return -1;
        }
        // Calculate the next index by adding the value at the current index
        int nextIndex = (index + nums[index]) % nums.length;
        // Handle negative indices by wrapping around to the end of the array
        if (nextIndex < 0) {
            nextIndex = nextIndex + nums.length;
        }
        // If the next index is the same as the current index, return -1
        if (nextIndex == index) {
            return -1;
        }
        // Return the calculated next index
        return nextIndex;
    }
}
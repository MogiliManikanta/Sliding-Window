class Solution {
    public int oddEvenJumps(int[] nums) {
    int length = nums.length; // Length of the input array
    int result = 1; // Initialize the result to 1, as we start at the last element and it's always a valid jump

    // Arrays to track if we can make higher or lower jumps from each element
    boolean[] canMakeHigherJump = new boolean[length];
    boolean[] canMakeLowerJump = new boolean[length];

    // Initialize the last element as both higher and lower jumps are possible
    canMakeHigherJump[length - 1] = true;
    canMakeLowerJump[length - 1] = true;

    // TreeMap to keep track of elements and their indices
    TreeMap<Integer, Integer> elementIndexMap = new TreeMap<>();
    elementIndexMap.put(nums[length - 1], length - 1); // Put the last element in the TreeMap

    // Traverse the array in reverse order, starting from the second-to-last element
    for (int i = length - 2; i >= 0; i--) {
        // Find the next higher element and the next lower element in the TreeMap
        Map.Entry<Integer, Integer> nextHigherEntry = elementIndexMap.ceilingEntry(nums[i]);
        Map.Entry<Integer, Integer> nextLowerEntry = elementIndexMap.floorEntry(nums[i]);

        // Check if a higher jump is possible from the current element
        if (nextHigherEntry != null) {
            canMakeHigherJump[i] = canMakeLowerJump[nextHigherEntry.getValue()];
        }

        // Check if a lower jump is possible from the current element
        if (nextLowerEntry != null) {
            canMakeLowerJump[i] = canMakeHigherJump[nextLowerEntry.getValue()];
        }

        // If a higher jump is possible from the current element, increment the result
        if (canMakeHigherJump[i]) {
            result++;
        }

        // Update the TreeMap with the current element and its index
        elementIndexMap.put(nums[i], i);
    }

    return result; // Return the final result
}
}
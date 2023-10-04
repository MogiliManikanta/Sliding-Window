class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store the elements from the input array 'nums' as keys
        // and their corresponding indices as values.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Loop through the elements in the 'nums' array.
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is not in the HashMap.
            if (!map.containsKey(nums[i])) {
                // If not, add it to the HashMap with its index as the value.
                map.put(nums[i], i);
            } else {
                // If the element is already in the HashMap, get its previous index.
                int pastIndex = map.get(nums[i]);
                
                // Check if the absolute difference between the current index 'i'
                // and the past index 'pastIndex' is less than or equal to 'k'.
                if (Math.abs(pastIndex - i) <= k) {
                    // If the condition is met, return true as we have found
                    // a duplicate element within the specified distance 'k'.
                    return true;
                } else {
                    // If the condition is not met, update the HashMap with the
                    // current index 'i' for the element 'nums[i]'.
                    map.put(nums[i], i);
                }
            }
        }
        
        // If no duplicates within the specified distance 'k' are found,
        // return false.
        return false;
    }
}

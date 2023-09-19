class Solution {
    public int findPairs(int[] nums, int k) {
        // Create a HashMap to store the frequency of each number in the array.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Check for edge cases: if 'nums' is null, empty, or 'k' is less than 0, return 0.
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        
        // Populate the HashMap with the frequency of each number in 'nums'.
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // Initialize a counter 'count' to keep track of the number of valid pairs.
        int count = 0;
        
        // Iterate through the HashMap using a Map.Entry.
        for (Map.Entry<Integer, Integer> traversingMap : map.entrySet()) {
            // If 'k' is 0, we're looking for pairs with the same number.
            if (k == 0) {
                // Check if there are at least two occurrences of the same number.
                if (traversingMap.getValue() >= 2) {
                    count++;
                }
            }
            // If 'k' is not 0, we're looking for pairs with a difference of 'k'.
            else { 
                // Check if there exists an element in the HashMap whose value is equal
                // to the current key plus 'k'. If so, increment 'count'.
                if (map.containsKey(traversingMap.getKey() + k)) {
                    count++;
                }
            }
        }
        
        // Return the count, which represents the number of valid pairs.
        return count; 
    }
}
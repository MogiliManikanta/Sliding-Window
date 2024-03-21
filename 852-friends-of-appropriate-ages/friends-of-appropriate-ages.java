class Solution {
    // Function to calculate the number of friend requests
    public int numFriendRequests(int[] ages) {
        // Creating a HashMap to count the occurrences of each age
        Map<Integer, Integer> count = new HashMap<>();
        
        // Counting the occurrences of each age
        for (int age : ages)
            count.put(age, count.getOrDefault(age, 0) + 1);
        
        // Initializing the result variable
        int res = 0;
        
        // Loop through each unique age 'a' in the count map
        for (Integer a : count.keySet())
            // Loop through each unique age 'b' in the count map
            for (Integer b : count.keySet())
                // Check if a friendship request should be made between age 'a' and age 'b'
                if (request(a, b)) 
                    // If yes, update the result by multiplying the count of age 'a' with the count of age 'b'
                    // Subtract 1 from the count of age 'b' if 'a' and 'b' are the same age
                    res += count.get(a) * (count.get(b) - (a == b ? 1 : 0));
        
        // Return the total number of friend requests
        return res;
    }

    // Function to check if a friendship request should be made between age 'a' and age 'b'
    private boolean request(int a, int b) {
        // Conditions for a friendship request:
        // 1. 'b' should not be younger than half of 'a' plus seven
        // 2. 'b' should not be older than 'a'
        // 3. If 'a' and 'b' are both over 100, 'a' should be less than 100
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
}

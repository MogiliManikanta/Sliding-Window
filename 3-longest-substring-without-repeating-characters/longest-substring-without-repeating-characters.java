class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> counts = new HashMap<>(); // Frequencies of chars in the window
        int res = 0;
        int i = 0; // Left pointer
        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            counts.put(currentChar, counts.getOrDefault(currentChar, 0) + 1); // Add right pointer to the window

            while (counts.get(currentChar) > 1) { // While the element at the right pointer created a repeat
                char leftChar = s.charAt(i);
                counts.put(leftChar, counts.get(leftChar) - 1); // While condition not valid, remove the element at the left pointer from the window by decreasing its count, and then increment the left pointer. In this case, it is while s[j] is a duplicate (we will stop after removing the duplicate copy of s[j]).
                i++; // Increment the left pointer
            } // Now the condition is valid
            res = Math.max(res, j - i + 1); // Update the global max with the length of the current valid substring
        }
        return res;
    }
}

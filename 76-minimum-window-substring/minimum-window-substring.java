class Solution {
    public String minWindow(String input, String pattern) {
        int[] frequencyMap = new int[128];
        // Count frequencies of characters in the pattern
        for (char c : pattern.toCharArray()) {
            frequencyMap[c]++;
        }

        // Initialize variables
        int remainingChars = pattern.length();
        int start = 0;
        int end = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minWindowStart = 0;

        // Sliding window approach
        while (end < input.length()) {
            if (frequencyMap[input.charAt(end++)]-- > 0) {
                remainingChars--;
            }

            // Shrink the window when all characters are found
            while (remainingChars == 0) {
                if (end - start < minWindowSize) {
                    minWindowSize = end - start;
                    minWindowStart = start;
                }
                
                if (frequencyMap[input.charAt(start)] == 0) {
                    remainingChars++;
                }
                frequencyMap[input.charAt(start)]++;
                start++;
            }
        }

        // Return the minimum window substring
        return minWindowSize == Integer.MAX_VALUE ? "" : input.substring(minWindowStart, minWindowStart + minWindowSize);
    }
}

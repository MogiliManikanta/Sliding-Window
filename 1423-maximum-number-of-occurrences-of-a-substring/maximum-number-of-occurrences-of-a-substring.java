class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    // Create a HashMap to store substrings and their occurrence count
    HashMap<String, Integer> map = new HashMap<>();
    int maxOccurrence = 0; // Initialize the maximum occurrence count
    
    // Iterate through the input string 's' from the beginning
    for (int i = 0; i < s.length(); i++) {
        // Initialize a HashMap to count the occurrence of letters in the current substring
        HashMap<Character, Integer> letterCount = new HashMap<>();
        int distinctLetters = 0; // Initialize the count of distinct letters in the current substring
        
        // Nested loop to generate and process all possible substrings starting at index 'i'
        for (int j = i; j < s.length() && j - i + 1 <= maxSize; j++) {
            char c = s.charAt(j); // Get the character at position 'j' in 's'
            
            // Check if the current character 'c' is not in the letter count map
            if (!letterCount.containsKey(c)) {
                distinctLetters++; // Increment the count of distinct letters
            }
            
            // Update the letter count for the current character
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            
            // If the count of distinct letters exceeds the maximum allowed
            // break out of the loop, as this substring won't satisfy the criteria
            if (distinctLetters > maxLetters) {
                break;
            }
            
            // If the length of the current substring is at least 'minSize'
            if (j - i + 1 >= minSize) {
                // Extract the current substring from 'i' to 'j' (inclusive)
                String substring = s.substring(i, j + 1);
                
                // Update the substring count in the map
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                
                // Update the maximum occurrence count if needed
                maxOccurrence = Math.max(maxOccurrence, map.get(substring));
            }
        }
    }
    
    return maxOccurrence; // Return the maximum occurrence count of a valid substring
}

}
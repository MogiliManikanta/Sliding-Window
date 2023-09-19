class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Check if the input string is empty, return 0 if it is.
        if (s.length() == 0)
            return 0;
        
        // Create a HashMap to store characters and their positions.
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        // Initialize variables to keep track of the maximum length and the start of the substring.
        int max = 0;  // This will store the length of the longest substring.
        int j = 0;    // This is the start of the current substring.
        
        // Loop through the characters of the input string.
        for (int i = 0; i < s.length(); ++i) {
            // Check if the character at position 'i' is already in the HashMap.
            if (map.containsKey(s.charAt(i))) {
                // If it is, update 'j' to the maximum of its current value and (previous position + 1).
                // This ensures that 'j' moves to the position right after the repeated character.
                 j = Math.max(j, map.get(s.charAt(i)) + 1);
                // // Alternatively, you can use the line below instead of the Math.max line:
                //  j = map.get(s.charAt(i)) + 1;
            }
            
            // Put the current character and its position into the HashMap.
            map.put(s.charAt(i), i);
            
            // Update 'max' with the maximum length of the current substring.
            max = Math.max(max, i - j + 1);
        }
        
        // Return the length of the longest substring without repeating characters.
        return max;
    }
}
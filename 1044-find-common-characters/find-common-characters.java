import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        // Initialize an array to represent the count of each character from 'a' to 'z'
        int[] charCount = new int[26];
        Arrays.fill(charCount, Integer.MAX_VALUE);
        
        // Iterate through each word
        for (String word : words) {
            // Create a temporary array to represent the count of each character in the current word
            int[] tempCharCount = new int[26];
            
            // Update the count of each character in the temporary array
            for (char c : word.toCharArray()) {
                tempCharCount[c - 'a']++;
            }
            
            // Update the count of each character in charCount to be the minimum frequency across all words
            for (int i = 0; i < 26; i++) {
                charCount[i] = Math.min(charCount[i], tempCharCount[i]);
            }
        }
        
        // Construct the result list
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charCount[i]; j++) {
                result.add(Character.toString((char)('a' + i)));
            }
        }
        
        return result;
    }
}

class Solution {
    public int compress(char[] chars) {
        // Check if the input character array is empty or has only one character
        if (chars == null || chars.length <= 1) {
            return chars.length;
        }
        // Initialize an index 'i' to track the current position in the compressed array
        int i = 0;
        // Iterate through the input character array
        for (int j = 1, count = 1; j <= chars.length; count++, j++) {
            // Check if the current character is different from the previous one or if we've reached the end
            if (j == chars.length || chars[j - 1] != chars[j]) {
                // Replace the character at index 'i' with the current character
                chars[i] = chars[j - 1];
                i++;
                
                // If the character repeated more than once, convert the count to a string
                // and add its digits to the compressed array
                if (count >= 2) {
                    for (char digit : String.valueOf(count).toCharArray()) {
                        chars[i] = digit;
                        i++;
                    }
                }
                
                // Reset the count for the next character
                count = 0;
            }
        }
        // 'i' now represents the length of the compressed array
        return i;
    }
}
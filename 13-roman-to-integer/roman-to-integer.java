class Solution {
    public int romanToInt(String s) {
        int result = 0; // Initialize the result to store the converted integer value.
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // Get the current character from the input Roman numeral string.
            int currentValue = getValue(ch); // Get the integer value of the current Roman numeral character.

            // Check if there is a next character in the string and if the current value is less
            // than the value of the next character (e.g., IV for 4 or IX for 9).
            if (i < s.length() - 1 && currentValue < getValue(s.charAt(i + 1))) {
                result -= currentValue; // Subtract the current value from the result.
            } else {
                result += currentValue; // Add the current value to the result.
            }
        }
        
        return result; // Return the final calculated integer value.
    }
    
    public int getValue(char c) {
        // A helper method to map Roman numerals to their corresponding integer values.
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                break;
        }
        return 0; // Return 0 if the character is not a valid Roman numeral (for error handling).
    }
}

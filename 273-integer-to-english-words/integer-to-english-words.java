class Solution {
    // Arrays to store English words for numbers less than 20, tens, and thousands.
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero"; // Handle the case when the input number is 0.

        int i = 0; // Initialize an index to keep track of the current THOUSANDS array element.
        String words = ""; // Initialize an empty string to store the result.

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words; // Convert the current three-digit group.
            num /= 1000; // Move to the next three-digit group.
            i++; // Increment the index for THOUSANDS.
        }

        return words.trim(); // Return the result after trimming any extra spaces.
    }

    // Helper function to convert a three-digit group to English words.
    private String helper(int num) {
        if (num == 0)
            return ""; // If the three-digit group is 0, return an empty string.
        else if (num < 20)
            return LESS_THAN_20[num] + " "; // If the group is less than 20, use the LESS_THAN_20 array.
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10); // If the group is between 20 and 99, use the TENS array.
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100); // For three-digit groups over 99, include the "Hundred" part.
    }
}
/**The numberToWords function takes an integer num as input and returns its English word representation.

It checks if num is 0, in which case it returns "Zero" as the result.

It iterates through num in groups of three digits (thousands) and converts each group to English words using the helper function. The THOUSANDS array is used to determine the appropriate magnitude (Thousand, Million, Billion, etc.) for each group.

The helper function takes a three-digit group as input and converts it into English words. Depending on the value of the group, it uses the LESS_THAN_20 array for numbers less than 20, the TENS array for numbers between 20 and 99, and includes the "Hundred" part for three-digit numbers over 99.

The result is constructed by concatenating the English word representation of each three-digit group with its corresponding magnitude (Thousand, Million, etc.) and adding spaces between them.

Finally, any extra spaces at the beginning or end of the result string are trimmed, and the result is returned. */
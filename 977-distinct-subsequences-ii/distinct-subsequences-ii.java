class Solution {
    public int distinctSubseqII(String S) {
    // Create an array to store the count of distinct subsequences ending with each letter (a to z).
    long end[] = new long[26];

    // Define a constant 'mod' to prevent large numbers from overflowing.
    long mod = (long)1e9 + 7;

    // Loop through each character in the input string 'S'.
    for (char c : S.toCharArray()) {
        // Calculate the sum of all counts in the 'end' array, then take the remainder when divided by 'mod'.
        long sumOfCounts = Arrays.stream(end).sum() % mod;
        
        // Increment the count for the current character by 1 and assign it to the 'end' array.
        end[c - 'a'] = sumOfCounts + 1;
    }

    // Calculate the sum of all counts in the 'end' array, then take the remainder when divided by 'mod'.
    long totalSum = Arrays.stream(end).sum() % mod;

    // Convert the final result to an integer and return it.
    return (int)totalSum;
}

}
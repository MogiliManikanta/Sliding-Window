class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>(); // Initialize a list to store the starting indices of anagrams
        if (p.length() > s.length()) return list; // Base Condition: If the length of 'p' is greater than 's', return an empty list.

        int N = s.length(); // Length of string 's'
        int M = p.length(); // Length of string 'p'

        int[] count = freq(p); // Initialize a character frequency array for string 'p' using the 'freq' function

        int[] currentCount = freq(s.substring(0, M)); // Initialize the character frequency array for the first 'M' characters of string 's'

        if (areSame(count, currentCount)) // Check if the initial substring of 's' is an anagram of 'p' using the 'areSame' function
            list.add(0); // If it is, add its starting index (0) to the list of indices

        int i;
        for (i = M; i < N; i++) { // Iterate through the rest of 's' from index 'M' to 'N-1'
            currentCount[s.charAt(i - M) - 'a']--; // Decrement the frequency of the character that is no longer in the sliding window (blue pointer)
            currentCount[s.charAt(i) - 'a']++; // Increment the frequency of the character that enters the sliding window (red pointer)

            if (areSame(count, currentCount)) { // Check if the character frequency arrays of 'p' and the current sliding window are the same
                list.add(i - M + 1); // If they are the same, add the starting index of the anagram to the list
            }
        }

        return list; // Return the list of starting indices of anagrams
    }

    private boolean areSame(int[] x, int[] y) {
        for (int i = 0; i < 26; i++) {
            if (x[i] != y[i]) // Compare the character frequencies of arrays 'x' and 'y'; if any frequencies are different, return false
                return false;
        }

        return true; // If all character frequencies are the same, return true
    }

    private int[] freq(String s) {
        int[] count = new int[26]; // Initialize an array of size 26 to store the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment the frequency of the character at position 'i'
        }

        return count; // Return the character frequency array
    }
}
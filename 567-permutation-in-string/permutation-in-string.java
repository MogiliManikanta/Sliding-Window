// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int len1 = s1.length(); // Length of string s1
//         int len2 = s2.length(); // Length of string s2

//         // If s1 is longer than s2, it's impossible for s1 to be a permutation of any substring of s2.
//         if (len1 > len2) {
//             return false;
//         }

//         // Initialize an array 'count' to keep track of character counts for each letter (a to z).
//         int[] count = new int[26];

//         // Initialize character counts for the first 'len1' characters in both strings.
//         for (int i = 0; i < len1; i++) {
//             count[s1.charAt(i) - 'a']++; // Increment count for s1 character.
//             count[s2.charAt(i) - 'a']--; // Decrement count for s2 character.
//         }

//         // If all counts are zero, it means s1 is a permutation of the initial substring of s2.
//         if (allZero(count)) {
//             return true;
//         }

//         // Move the sliding window through s2 and update character counts accordingly.
//         for (int i = len1; i < len2; i++) {
//             count[s2.charAt(i) - 'a']--;                  // Decrement count for new character at the right end of the window.
//             count[s2.charAt(i - len1) - 'a']++;           // Increment count for the character removed from the left end of the window.

//             // If all counts are zero, it means s1 is a permutation of the current substring of s2.
//             if (allZero(count)) {
//                 return true;
//             }
//         }

//         // If no permutation is found, return false.
//         return false;
//     }

//     // Helper function to check if all counts in the 'count' array are zero.
//     private boolean allZero(int[] count) {
//         for (int i = 0; i < 26; i++) {
//             if (count[i] != 0) {
//                 return false; // If any count is non-zero, return false.
//             }
//         }
//         return true; // All counts are zero.
//     }
// }


class Solution {
    public boolean checkInclusion(String p, String s) {
        //List<Integer> list = new ArrayList<Integer>(); // Initialize a list to store the starting indices of anagrams
        if (p.length() > s.length()) return false; // Base Condition: If the length of 'p' is greater than 's', return an empty list.

        int N = s.length(); // Length of string 's'
        int M = p.length(); // Length of string 'p'

        int[] count = freq(p); // Initialize a character frequency array for string 'p' using the 'freq' function

        int[] currentCount = freq(s.substring(0, M)); // Initialize the character frequency array for the first 'M' characters of string 's'

        if (areSame(count, currentCount)) // Check if the initial substring of 's' is an anagram of 'p' using the 'areSame' function
            // list.add(0); // If it is, add its starting index (0) to the list of indices
                return true;
        int i;
        for (i = M; i < N; i++) { // Iterate through the rest of 's' from index 'M' to 'N-1'
            currentCount[s.charAt(i - M) - 'a']--; // Decrement the frequency of the character that is no longer in the sliding window (blue pointer)
            currentCount[s.charAt(i) - 'a']++; // Increment the frequency of the character that enters the sliding window (red pointer)

            if (areSame(count, currentCount)) { // Check if the character frequency arrays of 'p' and the current sliding window are the same
                // list.add(i - M + 1); // If they are the same, add the starting index of the anagram to the list
                return true;
            }
        }

        return false; // Return the list of starting indices of anagrams
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
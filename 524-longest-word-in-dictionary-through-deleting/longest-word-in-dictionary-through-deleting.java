class Solution {
    public String findLongestWord(String s, List<String> d) {
    // Initialize an empty string 'res' to store the result.
    String res = "";

    // Iterate through each word 'w' in the list 'd'.
    for (String w : d) {
        // Check if 'w' is a subsequence of the input string 's'.
        if (isSubsequence(w, s)) {
            // If 'w' is a subsequence and longer than the current result,
            // update 'res' to 'w'.
            if (w.length() > res.length()) {
                res = w;
            }
            // If 'w' is of the same length as the current result and lexicographically smaller,
            // update 'res' to 'w'. This ensures that the smallest lexicographical word is chosen.
            if (w.length() == res.length() && w.compareTo(res) < 0) {
                res = w;
            }
        }
    }

    // Return the longest word found in 'd' that is a subsequence of 's'.
    return res;
}

// Helper function to check if 'w' is a subsequence of 's'.
boolean isSubsequence(String w, String s) {
    char[] wc = w.toCharArray(); // Convert 'w' to a character array.
    char[] sc = s.toCharArray(); // Convert 's' to a character array.
    int i = 0, j = 0;

    // Iterate through 'wc' and 'sc' to check if 'w' is a subsequence of 's'.
    while (i < wc.length && j < sc.length) {
        if (wc[i] == sc[j]) {
            i++;
        }
        j++;
    }

    // If 'i' reaches the length of 'w', it means 'w' is a subsequence of 's'.
    return i == wc.length;
}
}
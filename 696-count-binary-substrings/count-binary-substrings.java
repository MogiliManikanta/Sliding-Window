class Solution {
    public int countBinarySubstrings(String s) {
        // We start from the first character, so curConsecutive = 1
        int curConsecutive = 1, prevConsecutive = 0, ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                // Whenever the current and previous characters don't match
                // The number of substrings formed is the minimum of the current and previous count
                ans += Math.min(prevConsecutive, curConsecutive);
                // Previous consecutive streak will become the current consecutive streak
                prevConsecutive = curConsecutive;
                // Reset the current streak
                curConsecutive = 1;
            } else {
                curConsecutive++;
            }
        }
        // Required to include count from the last two groups of consecutive characters
        ans += Math.min(prevConsecutive, curConsecutive);
        return ans;
    }
}
/**1. 0011
In this string, consecutive count of binary characters are [2, 2]. We can form a total of 2 substrings.

2. 00011
In this string, consecutive count of binary characters are [3, 2]. Still, we can only form 2 substrings.

3. 000111
Here, consecutive count of binary characters are as - [3,3]. Now, we can form 3 substrings.

4. 00011100
Consecutive count of binary characters are - [3,3,2]. We can form 3 substrings with the first 2 groups of zeros and ones. 
Then we can form 2 substrings with the latter 2 groups. So, a total of 5 substrings.

5. 00011100111
Consecutive count - [3,3,2,3]. Substrings formed - 3 + 2 + 2 = 7 */
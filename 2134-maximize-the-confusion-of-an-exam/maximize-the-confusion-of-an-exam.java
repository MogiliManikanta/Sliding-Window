class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int start = 0;
        int countT = 0, countF = 0; // Counters for 'T' and 'F' characters
        int maxLen = 0; // Maximum consecutive answers

        for (int end = 0; end < n; end++) {
            // Update counters based on the current character
            if (answerKey.charAt(end) == 'T') {
                countT++;
            } else {
                countF++;
            }

            // If both counters exceed 'k', shrink the window from the left
            while (countT > k && countF > k) {
                if (answerKey.charAt(start) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                start++;
            }

            // Update the maximum consecutive answers
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}

class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int maxScore = 0;

    for (int left = 0; left < k; left++) {
        maxScore += cardPoints[left];
    }

    int windowSum = maxScore;
    for (int right = n - 1, left = k - 1; right >= n - k; right--, left--) {
        windowSum += cardPoints[right] - cardPoints[left];
        maxScore = Math.max(maxScore, windowSum);
    }

    return maxScore;
}

}
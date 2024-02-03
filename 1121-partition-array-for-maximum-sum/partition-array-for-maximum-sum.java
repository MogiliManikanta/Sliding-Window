class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            int curMax = 0, best = 0;
            for (int k = 1; k <= K && i - k >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k]);
                best = Math.max(best, dp[i - k] + curMax * k);
            }
            dp[i] = best;
        }
        return dp[N];
    }
}
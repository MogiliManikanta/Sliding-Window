class Solution {
        public int sumOfPower(int[] A, int k) {
        int n = A.length, mod = (int)1e9 + 7, res = 0, pow2 = 1;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int a : A)
            for (int v = k; v >= a; --v)
                for (int i = n; i > 0; --i)
                    dp[i][v] = (dp[i][v] + dp[i - 1][v - a]) % mod;
        for (int i = n; i > 0; --i) {
            res = (int)(res + (1L * pow2 * dp[i][k]) % mod) % mod;
            pow2 = (pow2 * 2) % mod;
        }
        return res;
    }
}
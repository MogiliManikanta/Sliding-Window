class Solution
{
    private int[][][][] dp;
    private int calcLen(int len)
    {
        if (len == 0) return 0;
        else if (len == 1) return 1;
        else if (len < 10) return 2;
        else if (len < 100) return 3;
        else return 4;
    }

    private int solve(int i, int ch, int len, int k, String str)
    {
        if (i == str.length()) return calcLen(len);
        if (dp[i][ch][len][k] == Integer.MAX_VALUE)
        {
            int c = str.charAt(i) - 'a';
            if (k > 0) dp[i][ch][len][k] = solve(i + 1, ch, len, k - 1, str);
            if (c == ch) dp[i][ch][len][k] = Math.min(dp[i][ch][len][k], solve(i + 1, ch, len + 1, k, str));
            else dp[i][ch][len][k] = Math.min(dp[i][ch][len][k], calcLen(len) + solve(i + 1, c, 1, k, str));
        }
        return dp[i][ch][len][k];
    }

    public int getLengthOfOptimalCompression(String s, int k)
    {
        int n = s.length();
        dp = new int[n][26][n + 1][k + 1];
        Arrays.stream(dp)
                .forEach(a -> Arrays.stream(a)
                        .forEach(b -> Arrays.stream(b)
                                .forEach(c -> Arrays.fill(c, Integer.MAX_VALUE))));
        return solve(0, 0, 0, k, s);
    }
}
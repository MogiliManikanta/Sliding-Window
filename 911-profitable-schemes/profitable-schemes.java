class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int len = group.length, sum = 0;
        for (int pro : profit) sum += pro;        
        long result = 0L;

        long[][] dp = new long[G + 1][sum + 1];
        dp[G][0] = 1;
        
        for (int i = 1; i <= len; i++){
            for (int j = 0; j <= G; j++){
                for (int k = 0; k <= sum; k++){
                    if (j + group[i - 1] <= G && k - profit[i - 1] >= 0){
                        dp[j][k] = dp[j][k] + dp[j + group[i - 1]][k - profit[i - 1]];
                    }
                    
                    if (i == len && k >= P) {
                        result += dp[j][k];
                        result %= 1_000_000_007;
                    }
                }
            }
        }
        
        return (int)(result % 1_000_000_007);
    }
}/*  


Here are some explanation
The definition of DP is the remain members can use, and current profit at i - 1 th item (since i is 1 based)
Thus the status transition function should be :
dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j + group[i - 1]][k - profit[i - 1]];
the transition fuction is weird at first,
but it could be clear if we write start case [0][G][0] and [1][G - 2][0 + 3]
it will more clear


*/
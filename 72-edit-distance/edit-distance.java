class Solution {
    public int minDistance(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 0+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i][j-1],//to insert
                               Math.min(dp[i-1][j],//to delete
                               dp[i-1][j-1]//to replace or swap
                                ));
                }
            }
        }
        return dp[m][n];
    }
}
/*
class Solution {
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
       int[] prev = new int[n+1];
       int[] curr = new int[n+1];
       for(int i=0;i<=n;i++){
           prev[i]=i;
       }
        for(int i=1;i<=m;i++){
            curr[0]=i;
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = 0+prev[j-1];
                }
                else{
                    curr[j] = 1+Math.min(prev[j],Math.min(curr[j-1],prev[j-1]));
                }
            }
            prev = (int[])curr.clone();
        }
        return prev[n];
    }
}*/
/*class Solution {
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
       int[][] dp = new int[m+1][n+1];
       for(int i=0;i<=m;i++){
           dp[i][0]=i;
       }
       for(int j=0;j<=n;j++){
           dp[0][j]=j;
       }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=0+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}*/

/*class Solution {
    public int function(String s,String t,int i,int j,int[][] dp){
        if(i==0){
            return j;
        }
        if(j==0){
            return i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j] =  0+function(s,t,i-1,j-1,dp);
        }
        return dp[i][j] = 1+Math.min(function(s,t,i-1,j,dp),Math.min(function(s,t,i,j-1,dp),function(s,t,i-1,j-1,dp)));
    }
    public int minDistance(String word1, String word2) {
       int m = word1.length();
       int n = word2.length();
       int[][]dp = new int[m+1][n+1];
       for(int i[] : dp){
           Arrays.fill(i,-1);
       }
       return  function(word1,word2,m,n,dp); 
    }
}*/

/** class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // i, j
        return dp(word1, m - 1, word2, n - 1);
    }

    public int dp(String word1, int i, String word2, int j) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            // do nothing
            memo[i][j] = dp(word1, i - 1, word2, j - 1);
        } else {
            memo[i][j] = min(
                // insert
                dp(word1, i, word2, j - 1) + 1,
                // delete
                dp(word1, i - 1, word2, j) + 1,
                // swap
                dp(word1, i - 1, word2, j - 1) + 1
            );
        }
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
} */
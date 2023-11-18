/*class Solution {
    public int function(String s,String t,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j] = 1+function(s,t,i-1,j-1,dp);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j] = Math.max(function(s,t,i-1,j,dp),function(s,t,i,j-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        int[][] dp = new int[m][m];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
       String rev = new StringBuilder(s).reverse().toString();
       return function(s,rev,m-1,m-1,dp); 
    }
}*/
/*class Solution{
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[m+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][m];
    }
}*/
/*
class Solution{
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        /*for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        } *
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev = (int[])curr.clone();
        }
        return prev[m];
    }
}*/

class Solution{
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return helper(s,sb.toString());
    }
    private int helper(String s,String t){
        int m=s.length();
        int n=t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
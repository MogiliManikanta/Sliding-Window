/*class Solution {
    public int function(int i ,int j,String s,String t){
        if(i<0 || j<0){
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)){
            return 1+function(i-1,j-1,s,t);
        }
        return Math.max(function(i-1,j,s,t),function(i,j-1,s,t));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return function(m-1,n-1,text1,text2);
    }
}*/
/*
class Solution {
    public int function(int i ,int j,String s,String t,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
           return dp[i][j]= 1+function(i-1,j-1,s,t,dp);
        }
        return dp[i][j]= Math.max(function(i-1,j,s,t,dp),function(i,j-1,s,t,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return function(m-1,n-1,text1,text2,dp);
    }
}*/


/*class Solution {
    public int function(int i ,int j,String s,String t,int[][] dp){
        if(i==0 || j==0){
            return 0;
        }\\\\\\\shifting the index for the base
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i-1)==t.charAt(j-1)){
           return dp[i][j]= 1+function(i-1,j-1,s,t,dp);
        }
        return dp[i][j]= Math.max(function(i-1,j,s,t,dp),function(i,j-1,s,t,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return function(m,n,text1,text2,dp);
    }
}*/
class Solution{
    public int longestCommonSubsequence(String s,String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
/*
class Solution{
    public int longestCommonSubsequence(String s,String t){
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int j=0;j<=n;j++){
            prev[j]=0;
        }
        /*for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }/
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=(int[])(curr.clone());
        }
        return prev[n];
    }
}*/
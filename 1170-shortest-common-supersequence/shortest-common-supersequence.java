class Solution {
    public String shortestCommonSupersequence(String s, String t) {
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
        int i=m,j=n;
        String result="";
        while(i>0 && j>0){
            if(s.charAt(i-1)==t.charAt(j-1)){
                result+=s.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                result+=s.charAt(i-1);
                i--;
            }
            else{
                result+=t.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            result+=s.charAt(i-1);
            i--;
        }
        while(j>0){
            result+=t.charAt(j-1);
            j--;
        }
        StringBuilder sb = new StringBuilder(result);
        sb.reverse();
        return sb.toString();
    }
}
class Solution {
    public int count(String s){
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                result++;
            }
        }
        return result;
    }
    public int findMax(String[] strs,int m,int n,int index,int[][][] dp){
        if(index == strs.length){
            return 0;
        }
        if(dp[m][n][index]!=-1){
            return dp[m][n][index];
        }
        int countZeroes = count(strs[index]);
        int countOnes = strs[index].length() - countZeroes;
        if(m-countZeroes>=0 && n-countOnes>=0){
            return dp[m][n][index] = Math.max(1+findMax(strs,m-countZeroes,n-countOnes,index+1,dp),findMax(strs,m,n,index+1,dp));
        }
        return dp[m][n][index] = findMax(strs,m,n,index+1,dp);
    }
    public int findMaxFormrecusive(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return findMax(strs,m,n,0,dp);
    }
    public int findMaxForm(String[] strs, int m, int n){
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int countZeroes = count(strs[i-1]);
                    int countOnes = strs[i-1].length()-countZeroes;
                    if(j-countZeroes >=0 && k-countOnes>=0){
                        dp[i][j][k] = Math.max(1+dp[i-1][j-countZeroes][k-countOnes],dp[i-1][j][k]);
                    }
                    else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
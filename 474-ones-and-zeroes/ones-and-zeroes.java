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
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j,-1);
            }
        }
        return findMax(strs,m,n,0,dp);
    }
}
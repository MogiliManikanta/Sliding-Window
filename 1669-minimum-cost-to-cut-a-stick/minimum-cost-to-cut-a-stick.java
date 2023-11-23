class Solution {
    public int helper(int i,int j,int[] arr,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int minCost=Integer.MAX_VALUE;
        for(int index=i;index<=j;index++){
            int cost=arr[j+1]-arr[i-1]+helper(i,index-1,arr,dp)+helper(index+1,j,arr,dp);
            minCost=Math.min(minCost,cost);
        }
        return dp[i][j]=minCost;
    }
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        int[] arr = new int[c+2];
        System.arraycopy(cuts,0,arr,1,cuts.length);
        arr[0]=0;
        arr[c+1]=n;
        Arrays.sort(arr);
        int[][] dp = new int[c+1][c+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return helper(1,c,arr,dp);
    }
}
class Solution {
    /*public int climbStairs(int n) {
       if(n==0 || n==1){
           return 1;
       }
       return climbStairs(n-1)+climbStairs(n-2); 
    }*/
    /*public int climbStairs(int n) {
        int  dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }*/
    public int climbStairs(int n) {
        int prev1=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int temp=prev1+prev2;
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}
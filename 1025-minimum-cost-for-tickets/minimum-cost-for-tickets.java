class Solution {
    private int sub(int[] day,int[] cost,int si,int[] dp){
        int n=day.length;
        if(si>=n){
            return 0;
        }
        if(dp[si]!=-1){
            return dp[si];
        }

        int one_day = cost[0]+sub(day,cost,si+1,dp);
        int i;
        for(i=si;i<n && day[i]<day[si]+7;i++);
            
        int seven_day = cost[1]+sub(day,cost,i,dp);

        for(i=si;i<n && day[i]<day[si]+30;i++);
        
        int thirty_day = cost[2]+sub(day,cost,i,dp);

        return dp[si]= Math.min(one_day,Math.min(seven_day,thirty_day));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[367];
        Arrays.fill(dp,-1);
         return sub(days,costs,0,dp);
    }
}
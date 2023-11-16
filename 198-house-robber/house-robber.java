class Solution {
    public int helper(int[] nums,int index,int[] dp){
        if(index<0){
            return 0;
        }
        if(index==0){
            return nums[index];
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick=nums[index]+helper(nums,index-2,dp);
        int notpick = 0+helper(nums,index-1,dp);
        return dp[index] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        /* First Approach
            int[] dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return helper(nums,nums.length-1,dp); 
       */
        /*    
            int n=nums.length;
            int[] dp = new int[n];
            dp[0]=nums[0];
            for(int i=1;i<n;i++){
                int pick=nums[i];
                if(i>1){
                    pick+=dp[i-2];
                }
                int notpick = 0+dp[i-1];
                dp[i]=Math.max(pick,notpick);
            }
            return dp[n-1];
        */
        int n = nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick+=prev2;
            }
            int notpick = 0+prev1;
            int curr = Math.max(pick,notpick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
/**class Solution {
   /* the order is: prev2, prev1, num  
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
}
}
/**
This particular problem and most of others can be approached using the following sequence:

Find recursive relation
Recursive (top-down)
Recursive + memo (top-down)
Iterative + memo (bottom-up)
Iterative + N variables (bottom-up)

robbery of current house + loot from houses before the previous
loot from the previous house robbery and any loot captured before that
rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

*/


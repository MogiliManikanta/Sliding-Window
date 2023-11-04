class Solution {
    public boolean canPartition(int[] nums) {
       int sum=0;
			 for(int i=0;i<nums.length;i++){
				 sum+=nums[i];
			 }
			 if(sum%2==1){
				 return false;
			 }
			 int n= nums.length;
			 int target=sum/2;
			 boolean dp[] = new boolean[target+1];
			 dp[0]=true;
			 for(int i=0;i<n;i++){
				 for(int j=target;j>=nums[i];j--){
					 dp[j]=dp[j]||dp[j-nums[i]];
				 }
			 }
			 return dp[target]; 
    }
}
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }
    int helper(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int left=0,right=0,cnt=0,sum=0;
        while(right<nums.length){
            sum+=nums[right];
            while(left<right && sum>goal){
                sum-=nums[left];
                left++;
            }
            if(sum<=goal){
                cnt+=right-left+1;
            }
            right++;
        }
        return cnt;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    int helper(int[] nums,int goal){
        if(goal<0) return 0;
        int sum=0,left=0,right=0,cnt=0;
        while(right<nums.length){
            sum+=nums[right]%2;
            while(left<right && sum>goal){
                sum-=nums[left]%2;
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
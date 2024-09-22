class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxi=nums[0];
        for(int i : nums){
            sum+=i;
            maxi = sum>maxi?sum:maxi;
            sum=sum<0?0:sum;
        }
        return maxi;
    }
}
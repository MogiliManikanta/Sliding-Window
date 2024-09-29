class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0, maxi= - (int)1e9,n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxi=Math.max(sum,maxi);
            if(sum<0) sum=0;
        }
        return maxi;
    }
}
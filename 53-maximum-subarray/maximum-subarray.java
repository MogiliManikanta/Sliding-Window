class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            // sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            sum+=nums[i];
            max=Math.max(sum,max);
        }
        return max;
    }
}
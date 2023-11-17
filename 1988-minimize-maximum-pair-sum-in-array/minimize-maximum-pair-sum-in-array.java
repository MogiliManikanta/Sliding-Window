class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);//array should be started
        int result=Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n/2;i++){
            result = Math.max(result,nums[i]+nums[n-i-1]);//storing the result 
        }
        return result;
    }
}
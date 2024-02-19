class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(i+k-1 >= nums.length) break;
            res = Math.min(res, nums[i+k-1] - nums[i]);
        }
        return res;
    }
}
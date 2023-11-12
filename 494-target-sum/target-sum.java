class Solution {

    public int recursive(int[] nums,int target,int sum,int ind){
        if(ind==nums.length){
            if(target==sum){
                return 1;
            }
            return 0;
        }

        int positive = recursive(nums,target,sum+nums[ind],ind+1);
        int negative = recursive(nums,target,sum-nums[ind],ind+1);
        return negative+positive;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recursive(nums,target,0,0);
    }
}
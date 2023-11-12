/*class Solution {

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
}*/

public class Solution {
    public int recursive(int[] nums, int target, int sum, int ind, int[][] memo) {
        if (ind == nums.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        if (memo[ind][sum + 1000] != 0) {
            return memo[ind][sum + 1000];
        }

        int positive = recursive(nums, target, sum + nums[ind], ind + 1, memo);
        int negative = recursive(nums, target, sum - nums[ind], ind + 1, memo);

        memo[ind][sum + 1000] = negative + positive;

        return memo[ind][sum + 1000];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[nums.length][2001]; // Range of sum is -1000 to 1000

        return recursive(nums, target, 0, 0, memo);
    }
}

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
/*
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
}*/

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        // corner case if sum - target is odd or negative
        if ((sum - target) % 2 != 0 || (sum - target) < 0) {
            return 0;
        }
        
        target = (sum - target) / 2;
        
        int[][] dp = new int[n + 1][target + 1];
        
        // initializing first column by 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // initializing first row by 0 (from the second element, i.e., index = 1)
        for (int i = 1; i <= target; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][target];
    }
}

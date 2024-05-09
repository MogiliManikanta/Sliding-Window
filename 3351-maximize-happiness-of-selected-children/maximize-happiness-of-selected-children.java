import java.util.Arrays;
class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int j = 0,i = nums.length - 1;
        while (0<k--&& 0 <= i) {
            if (0 < nums[i]) {
                sum =sum+ Math.max(0, nums[i] - j);
                j+=1;
                nums[i] = nums[i] - j;
                i-=1;
            }
        }
        return sum;
    }
}

class Solution {
    public  boolean condition(int divisor,int[] nums,int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num - 1) / divisor + 1;
        }
        return sum <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = max(nums);

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (condition(mid,nums,threshold)) {
            right = mid-1;
        } else {
            left = mid + 1;
        }
    }
    return left;
    }
    public int max(int[] nums){
        int maxValue=0;
        for(int i:nums){
            maxValue = Math.max(i,maxValue);
        }
        return maxValue;
    }
}
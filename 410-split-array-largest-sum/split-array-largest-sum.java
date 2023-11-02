class Solution {
    public boolean isFeasible(int[] nums, int k, int threshold) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > threshold) {
                sum = num;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int left = max(nums);
        int right = sum(nums);
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isFeasible(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }  
        return left;
    }
    public int max(int[] nums){
        int maxValue=Integer.MIN_VALUE;
        for(int i : nums){
            maxValue=Math.max(maxValue,i);
        }
        return maxValue;
    }
    public int sum(int[] nums){
        int sumValue=0;
        for(int i:nums){
            sumValue+=i;
        }
        return sumValue;
    }
}
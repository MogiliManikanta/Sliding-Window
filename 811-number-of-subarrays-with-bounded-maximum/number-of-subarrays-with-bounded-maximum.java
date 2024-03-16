class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0, leftIdx = -1, rightIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) 
                leftIdx = i;
            if (nums[i] >= left) 
                rightIdx = i;
            result += rightIdx - leftIdx;
        }
        return result;
    }
}

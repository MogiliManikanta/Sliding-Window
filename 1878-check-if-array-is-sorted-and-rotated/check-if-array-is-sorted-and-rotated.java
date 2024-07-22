class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, dropPoint = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) dropPoint++;
        }
        if (dropPoint == 0) return true;
        if (dropPoint == 1 && nums[0] >= nums[n - 1]) return true;
        return false;
    }
}

/**
NonSequence = nums[i] > nums[i+1] i.e. number is greater than its right.
Find non sequences count. 
-- In case of sorted array there will be 0 nonsequences. 
   [1,2,3,4,5]
-- In case of rotated sorted array there will be 1 nonsequence.
   [3,4,5,1,2]
-- In other cases like [2,1,3,4] nonsequences > 1 ==> 2

   How to count 4 > 2, in that case we need nums[i] > nums[(i+1)%len]

*****/

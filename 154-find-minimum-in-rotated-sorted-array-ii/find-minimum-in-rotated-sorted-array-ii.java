class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] < nums[high]) {
                // Right side is sorted, move left
                high = mid;
            } else if (nums[mid] > nums[high]) {
                // Left side is sorted, move right
                low = mid + 1;
            } else {
                // Handle duplicates by moving right pointer inward
                high--;
            }
        }
        
        return nums[low];
    }
}

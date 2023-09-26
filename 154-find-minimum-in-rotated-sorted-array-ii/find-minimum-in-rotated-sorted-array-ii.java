class Solution 
{
    public int findMin(int[] nums) 
    {
        int low = 0;
        int high = nums.length-1;
        // loop invariant: 1. low < high
        //                 2. mid != high and thus A[mid] != A[high] (no duplicate exists)
        //                 3. minimum is between [low, high]
        // The proof that the loop will exit: after each iteration either the 'high' decreases
        // or the 'low' increases, so the interval [low, high] will always shrink.
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high])
                // the mininum is in the left part
                high = mid;
            else if (nums[mid] > nums[high])
                // the mininum is in the right part
                low = mid + 1;
            else 
                high--;
        }

        return nums[low];
    }
}
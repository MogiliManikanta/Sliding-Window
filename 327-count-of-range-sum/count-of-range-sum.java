class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
    // Get the length of the input array 'nums'.
    int n = nums.length;
    
    // Create an array 'prefixSums' to store the cumulative sums of 'nums'.
    long[] prefixSums = new long[n + 1];
    
    // Calculate the cumulative sums and store them in 'prefixSums'.
    for (int i = 0; i < n; ++i)
        prefixSums[i + 1] = prefixSums[i] + nums[i];
    
    // Call the recursive helper function to count the number of subarrays
    // in 'nums' with sums within the specified range [lower, upper].
    return countWhileMergeSort(prefixSums, 0, n + 1, lower, upper);
}

// This is a recursive helper function to count subarrays with sums in the specified range.
private int countWhileMergeSort(long[] prefixSums, int start, int end, int lower, int upper) {
    // If there is only one element or no element in the subarray, return 0.
    if (end - start <= 1)
        return 0;
    
    // Find the middle index of the subarray.
    int mid = (start + end) / 2;
    
    // Recursively count subarrays in the left and right halves and sum them.
    int count = countWhileMergeSort(prefixSums, start, mid, lower, upper)
              + countWhileMergeSort(prefixSums, mid, end, lower, upper);
    
    // Initialize three pointers, j, k, and t, for the merge process.
    int j = mid, k = mid, t = mid;
    
    // Create a temporary array 'cache' to store merged values.
    long[] cache = new long[end - start];
    
    // Iterate through the left half of the subarray.
    for (int i = start, r = 0; i < mid; ++i, ++r) {
        // Count the number of elements in the right half such that
        // (prefixSums[k] - prefixSums[i]) is less than 'lower'.
        while (k < end && prefixSums[k] - prefixSums[i] < lower)
            k++;
        
        // Count the number of elements in the right half such that
        // (prefixSums[j] - prefixSums[i]) is less than or equal to 'upper'.
        while (j < end && prefixSums[j] - prefixSums[i] <= upper)
            j++;
        
        // Count the number of elements in the right half such that
        // 'prefixSums[t]' is less than 'prefixSums[i]' and merge them into 'cache'.
        while (t < end && prefixSums[t] < prefixSums[i])
            cache[r++] = prefixSums[t++];
        
        // Merge the current 'prefixSums[i]' into 'cache'.
        cache[r] = prefixSums[i];
        
        // Update the 'count' by adding the difference between 'j' and 'k'.
        count += j - k;
    }
    
    // Copy the merged values from 'cache' back to 'prefixSums'.
    System.arraycopy(cache, 0, prefixSums, start, t - start);
    
    // Return the total count of subarrays within the specified range.
    return count;
}
}
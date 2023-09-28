public class Solution {
    // Merge function to merge two sorted subarrays and count reverse pairs
    private void merge(int[] nums, int low, int mid, int high, int[] count) {
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            // Count reverse pairs by comparing nums[i] with 2 * nums[j]
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            // Increment the count with the number of valid reverse pairs
            count[0] += j - (mid + 1);
        }
        
        // Create a temporary array to merge the sorted subarrays
        int size = high - low + 1;
        int[] temp = new int[size];
        int left = low, right = mid + 1, k = 0;
        
        // Merge the subarrays into the temporary array
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        
        // Copy any remaining elements from the left subarray
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        
        // Copy any remaining elements from the right subarray
        while (right <= high) {
            temp[k++] = nums[right++];
        }
        
        // Copy the merged elements from the temporary array back to the original array
        int m = 0;
        for (int i = low; i <= high; i++) {
            nums[i] = temp[m++];
        }
    }

    // MergeSort function to sort and count reverse pairs in the array
    private void mergeSort(int[] nums, int low, int high, int[] count) {
        if (low >= high) {
            return; // Base case: if the array has only one element, it's already sorted
        }
        
        // Calculate the middle index
        int mid = (low + high) / 2;
        
        // Recursively sort the left and right halves of the array
        mergeSort(nums, low, mid, count);
        mergeSort(nums, mid + 1, high, count);
        
        // Merge the two sorted halves and count reverse pairs
        merge(nums, low, mid, high, count);
    }

    // Public function to count reverse pairs in the given array
    public int reversePairs(int[] nums) {
        // Initialize an array to hold the count of reverse pairs
        int[] count = {0};
        
        // Call the MergeSort function to sort and count reverse pairs
        mergeSort(nums, 0, nums.length - 1, count);
        
        // Return the total count of reverse pairs
        return count[0];
    }
}

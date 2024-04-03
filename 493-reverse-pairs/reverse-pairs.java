public class Solution {
    // The main function to count reverse pairs
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1); // Call the mergeSort function on the entire array
    }

    // Merge function to merge two sorted subarrays
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Create a temporary ArrayList for merging
        int left = low;      // Initialize the starting index of the left half of arr
        int right = mid + 1; // Initialize the starting index of the right half of arr

        // Store elements in the temporary ArrayList in a sorted manner
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]); // Add the smaller element from the left subarray
                left++;
            } else {
                temp.add(arr[right]); // Add the smaller element from the right subarray
                right++;
            }
        }

        // If elements on the left half are still left, add them to the temporary ArrayList
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // If elements on the right half are still left, add them to the temporary ArrayList
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transfer all elements from the temporary ArrayList back to the original arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low); // Using (i - low) to map the index correctly
        }
    }

    // Function to count pairs that satisfy the condition (arr[i] > 2 * arr[j])
    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1; // Initialize the pointer for the right subarray
        int cnt = 0; // Initialize a counter for counting pairs

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++; // Move the right pointer until the condition is satisfied
            }
            cnt += (right - (mid + 1)); // Increment the counter by the number of valid pairs
        }

        return cnt; // Return the count of pairs satisfying the condition
    }

    // MergeSort function to sort the array and count reverse pairs
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0; // Initialize a counter for counting reverse pairs

        // Base case: If the subarray has only one element or is empty, return 0
        if (low >= high) {
            return cnt;
        }

        int mid = (low + high) / 2; // Calculate the middle index

        // Recursively sort and count pairs in the left and right halves
        cnt += mergeSort(arr, low, mid); // Left half
        cnt += mergeSort(arr, mid + 1, high); // Right half

        cnt += countPairs(arr, low, mid, high); // Count pairs for merged halves
        merge(arr, low, mid, high); // Merge the sorted halves

        return cnt; // Return the total count of reverse pairs in the subarray
    }
}

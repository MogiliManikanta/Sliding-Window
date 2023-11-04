class Solution {
    public int lengthOfLIS(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        
        // Create an array 'temp' to store the longest increasing subsequence
        int temp[] = new int[n];
        
        // Initialize a variable 'k' to keep track of the current position in 'temp'
        int k = 0;
        
        // Initialize the first element of 'temp' with the first element of 'nums'
        temp[k] = nums[0];
        
        // Loop through the elements of 'nums' starting from the second element (index 1)
        for (int i = 1; i < n; i++) {
            // Check if the current element in 'nums' is smaller than the last element in 'temp'
            if (nums[i] < temp[k]) {
                // If it is smaller, perform a binary search to find the correct position
                int lowerbound = 0;
                int upperbound = k;
                while (lowerbound <= upperbound) {
                    int mid = (lowerbound + upperbound) / 2;
                    if (temp[mid] < nums[i]) {
                        lowerbound = mid + 1;
                    } else {
                        upperbound = mid - 1;
                    }
                }
                // Update 'temp' with the current element at the correct position
                temp[lowerbound] = nums[i];
            } else if (nums[i] != temp[k]) {
                // If the current element is not equal to the last element in 'temp' and not smaller,
                // increment 'k' and add the current element to 'temp'
                k++;
                temp[k] = nums[i];
            }
        }
        
        // The value of 'k' represents the length of the longest increasing subsequence
        return k + 1;
    }
}

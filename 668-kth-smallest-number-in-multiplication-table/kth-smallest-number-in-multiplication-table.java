class Solution {
    public int findKthNumber(int m, int n, int k) {
    return findKthNumberHelper(m, n, k, 1, m * n);
}

private boolean enough(int num, int m, int n, int k) {
    // This is a helper function that checks if there are at least k numbers
    // in the multiplication table that are smaller than or equal to num
    // It does this by counting the number of multiples of each row value
    // that are smaller than or equal to num
    int count = 0;
    for (int val = 1; val <= m; val++) {
        // For each row value from 1 to m
        int add = Math.min(num / val, n);
        // The number of multiples of val that are smaller than or equal to num
        // is either num / val or n, whichever is smaller
        if (add == 0) {
            break;
            // If there are no multiples of val that are smaller than or equal to num
            // then we can stop counting as the rest of the rows will also have zero
        }
        count += add;
        // Add the number of multiples to the total count
    }
    return count >= k;
    // Return true if the count is greater than or equal to k, false otherwise
}

private int findKthNumberHelper(int m, int n, int k, int left, int right) {
    // This is another helper function that performs a binary search on the range
    // of possible answers from left to right
    while (left < right) {
        // While the range is not empty
        int mid = left + (right - left) / 2;
        // Find the middle point of the range
        if (enough(mid, m, n, k)) {
            right = mid;
            // If there are at least k numbers in the multiplication table that are smaller than or equal to mid
            // then the answer must be in the left half of the range, so we update right to mid
        } else {
            left = mid + 1;
            // Otherwise, the answer must be in the right half of the range, so we update left to mid + 1
        }
    }
    return left;
    // When the range becomes empty, left and right are equal and they are the answer
}

}
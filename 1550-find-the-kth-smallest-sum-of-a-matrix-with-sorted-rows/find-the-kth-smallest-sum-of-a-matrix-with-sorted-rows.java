class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int left = m, right = m * 5000, ans = -1;
        
        // Binary search to find the kth smallest value
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle value
            int cnt = countArraysHaveSumLessOrEqual(mat, m, n, mid, 0, 0, k); // Count arrays with sum <= mid
            if (cnt >= k) {
                ans = mid; // If we found k or more arrays with sum <= mid, update the answer
                right = mid - 1; // Move the right boundary to search for a smaller value
            } else {
                left = mid + 1; // If we found less than k arrays with sum <= mid, search for a larger value
            }
        }
        return ans; // Return the kth smallest value
    }

    int countArraysHaveSumLessOrEqual(int[][] mat, int m, int n, int targetSum, int r, int sum, int k) {
        if (sum > targetSum) return 0; // If the current sum exceeds the target, return 0
        if (r == m) return 1; // If we have reached the end of the row (found a valid array), return 1
        
        int ans = 0;
        for (int c = 0; c < n; ++c) {
            int cnt = countArraysHaveSumLessOrEqual(mat, m, n, targetSum, r + 1, sum + mat[r][c], k - ans);
            // Recursively count arrays by considering the next row and updating the sum
            if (cnt == 0) break; // If cnt is 0, no need to process further (pruning)
            
            ans += cnt; // Update the total count of arrays
            if (ans > k) break; // If the count exceeds k, no need to process further (pruning)
        }
        return ans; // Return the total count of arrays with sum <= targetSum
    }
}

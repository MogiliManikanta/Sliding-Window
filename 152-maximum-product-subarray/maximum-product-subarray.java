class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;

        int maxProduct = arr[0];
        int minProduct = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                // Swap maxProduct and minProduct when arr[i] is negative
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Calculate the maximum product ending at the current position
            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            // Calculate the minimum product ending at the current position
            minProduct = Math.min(arr[i], minProduct * arr[i]);

            // Update the global maximum product found so far
            ans = Math.max(ans, maxProduct);
        }

        return ans;
    }
}

class Solution {
     public int maxProduct(int[] nums) {
        int mx1 = Integer.MIN_VALUE, mx2 = mx1;
        for (int n : nums) {
            if (n > mx1) {
                mx2 = mx1;
                mx1 = n;
            }else if (n > mx2) {
                mx2 = n;
            }
        }
        return (mx1 - 1) * (mx2 - 1);
    }
}
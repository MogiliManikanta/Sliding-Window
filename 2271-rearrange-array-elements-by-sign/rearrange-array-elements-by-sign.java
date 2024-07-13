class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos_index = 0, neg_index = 1; 
        for (int i=0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos_index] = nums[i];
                pos_index += 2;
            }
            if (nums[i] < 0) {
                ans[neg_index] = nums[i];
                neg_index += 2;
            }
        }
        return ans;
    }
}
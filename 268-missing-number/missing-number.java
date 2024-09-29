class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int arSum=0;
        int sum = (n * (n+1))/2;
        for(int i=0;i<n;i++) {
            arSum+=nums[i];
        }
        return sum-arSum;
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            int zeroes=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeroes++;
                }
                if(zeroes<=k){
                    maxi=Math.max(maxi,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxi;
    }
}
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum=0,maxi=0,n=nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]==0){
                sum=0;
            }
            else{
                sum+=nums[i];
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
    }
}

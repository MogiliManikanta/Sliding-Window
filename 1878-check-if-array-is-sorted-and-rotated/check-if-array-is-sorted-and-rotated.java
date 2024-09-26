class Solution {
    public boolean check(int[] nums) {
        int drop=0,n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) {
                drop++;
            }
        }
        if(drop==0) return true;
        else if(drop==1 && nums[0]>=nums[n-1]) return true;
        else return false;
    }
}
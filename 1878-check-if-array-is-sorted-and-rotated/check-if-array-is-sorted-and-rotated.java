class Solution {
    public boolean check(int[] nums) {
        int dropPoint=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) dropPoint++;
            if(dropPoint>1) return false;
        }
        if(dropPoint==0) return true;
        if(dropPoint ==1 && nums[0]>=nums[n-1]) return true;
        return false;
    }
}
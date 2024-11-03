class Solution {
    public boolean check(int[] nums) {
        int dropPoint=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                dropPoint++;
            }
        }
        if(dropPoint==0) return true;
        else if(dropPoint==1 && nums[0]>=nums[nums.length-1]) return true;
        else return false;
    }
}
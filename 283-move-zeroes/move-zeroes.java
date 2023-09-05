class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int index=0;
        for(int ele : nums){
            if(ele!=0){
                nums[index++]=ele;
            }
        }
        while(index<n){
            nums[index++]=0;
        }
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                nums[++index]=nums[i];  
            }
        }
        return index+1;
    }
}
// [0,0,1,1,1,2,2,3,3,4]
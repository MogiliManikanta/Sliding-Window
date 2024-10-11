class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(i<1 || nums[i]>nums[index-1]){
                nums[index]=nums[i];  
                index++;
            }
        }
        return index;
    }
}
// [0,0,1,1,1,2,2,3,3,4]
class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int n : nums){
            if(index<2 || n>nums[index-2]){
                nums[index++] = n;
            }
        }
        return index;
    }
}
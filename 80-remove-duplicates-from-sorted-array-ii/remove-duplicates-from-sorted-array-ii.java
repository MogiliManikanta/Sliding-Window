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

/**class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(i<2 || nums[index-2]<nums[i]) {
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }
} */
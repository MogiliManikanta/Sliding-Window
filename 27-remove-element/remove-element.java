class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int index=0;
        for(int j=0;j<n;j++){
            if(nums[j]!=val){
                int temp=nums[index];
                nums[index]=nums[j];
                nums[j]=temp;
                index++;
            }
        }
        return index;
    }
}
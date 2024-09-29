class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0,neg=1;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                result[neg] = nums[i];
                neg+=2;
            }
            else {
                result[pos] = nums[i];
                pos+=2;
            }
        }
        return result;
    }
}
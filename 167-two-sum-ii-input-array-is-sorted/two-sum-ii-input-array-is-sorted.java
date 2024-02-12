class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n =  nums.length;
        int right=n-1; // starting from the end of the array
        int  left=0; // starting from the array
        int index[] = new int[2];
        while(left<right){ // simple logic easy
            if(nums[left]+nums[right]==target){ // given array already sorted
                index[0]=left+1; // storing the left index
                index[1]=right+1; // storing thwe right index
                return index;
            }
            else if(nums[left]+nums[right]<target){
                left++; // incrementing the left index
            }
            else{
                right--; // decrement the right index
            }
        }
        return index; // if target not found return empty list
    }
}
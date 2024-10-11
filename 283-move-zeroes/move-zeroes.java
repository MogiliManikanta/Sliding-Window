class Solution {
    public void moveZeroes(int[] nums) {
        int swapBallsSize=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) swapBallsSize++;
            else{
                if(swapBallsSize>0) { 
                    int temp=nums[i];
                    nums[i]=nums[i-swapBallsSize];
                    nums[i-swapBallsSize] = temp;
                }
            }
        }
    }
}
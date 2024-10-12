class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }
            if(nums[i]==0){
                sum=0;
            }
        }
        return max;
    }
}
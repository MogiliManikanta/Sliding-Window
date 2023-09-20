class Solution {
    public int minOperations(int[] nums, int x) {
        int target=-x;
        for(int i : nums){
            target+=i;
        }
        if(target<0){
            return -1;
        }
        int result=-1;
        int sum=0;
        int n=nums.length,left=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>target){
                while(sum>target){
                    sum-=nums[left];
                    left++;
                }
            }
            if(sum==target){
                result=Math.max(result,i-left+1);
            }
        }
        return result==-1?-1:n-result;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int sum=0;
       int left=0;
       int n = nums.length;
       int right=0;
       int shortest=Integer.MAX_VALUE;
       while(right<n){
           sum+=nums[right];
           right++;
        //    if(sum>=target){
               while(sum>=target){
                   shortest=Math.min(shortest,right-left);
                   sum-=nums[left];
                   left++;
               }
        //    }
       }
       return shortest==Integer.MAX_VALUE ? 0 : shortest; 
    }
}
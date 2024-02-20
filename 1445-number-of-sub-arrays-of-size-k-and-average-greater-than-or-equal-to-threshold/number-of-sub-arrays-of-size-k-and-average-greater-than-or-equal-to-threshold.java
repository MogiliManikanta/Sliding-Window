class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int count=0;
        if(sum>=threshold*k){
            count++;
        }
        for(int i=k;i<nums.length;i++){
            sum+=(nums[i]-nums[i-k]);
            // sum-=nums[i];
            if(sum>=threshold*k){
                count++;
            }
        }
        return count;
    }
}
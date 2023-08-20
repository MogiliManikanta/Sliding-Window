class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long count=0,minIndex=-1,maxIndex=-1,badIndex=-1;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK){
                badIndex=i;
            }
            if(nums[i]==minK){
                minIndex=i;
            }
            if(nums[i]==maxK){
                maxIndex=i;
            }
            count+=Math.max(0L,Math.min(minIndex,maxIndex)-badIndex);
        }
        return count;
    }
}
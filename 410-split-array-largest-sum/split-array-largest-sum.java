class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int i=0;i<nums.length;i++) {
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        int ans=0;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(possible(mid,nums,k)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
    public boolean possible(int mid,int[] nums,int k){
        int noOfSub =1,sum=0;
        for(int i=0;i<nums.length;i++) {
            if(sum+nums[i]>mid) {
                noOfSub++;
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }
        return noOfSub <= k;
    }
}
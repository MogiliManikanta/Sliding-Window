class Solution {
    public int splitArray(int[] nums, int k) {
        int maxi =0,sum=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
            sum+=nums[i];
        }
        int low=maxi,high=sum,ans=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(possible(mid,k,nums)){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int limit,int k,int[] nums){
        int noOfSubarrays=1;
        int capacity=0;
        for(int i=0;i<nums.length;i++){
            if(capacity+nums[i]>limit){
                capacity=nums[i];
                noOfSubarrays++;
            }else{
                capacity+=nums[i];
            }
        }
        return noOfSubarrays<=k;
    }
}
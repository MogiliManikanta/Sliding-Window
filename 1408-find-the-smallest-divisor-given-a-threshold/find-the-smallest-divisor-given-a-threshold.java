class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            low=Math.min(low,nums[i]);
            high=Math.max(high,nums[i]);
        }
        int ans=-1;
        low=1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(possible(mid,threshold,nums)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int limit,int[] nums){
    long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]+mid-1)/mid;
        }
        return sum<=limit;
    }
}
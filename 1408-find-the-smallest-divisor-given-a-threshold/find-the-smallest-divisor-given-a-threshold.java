class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=-(int)1e9;
        for(int i=0;i<nums.length;i++) {
            high=Math.max(high,nums[i]);
        }
        int ans=0;
        while(low<=high) {
            int mid=(low + (high-low)/2);
            if(possible(mid,nums,threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int[] nums,long threshold) {
        long divisors=0;
        for(int i=0;i<nums.length;i++) {
            divisors += (nums[i]+mid-1)/mid;
        }
        return divisors<=threshold;
    }
}
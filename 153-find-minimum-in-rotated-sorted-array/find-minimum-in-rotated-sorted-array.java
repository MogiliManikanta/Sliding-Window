class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int ans=(int)1e9;
        while(low<=high) {
            int mid = (low+(high-low)/2);
            if(nums[low]<=nums[mid]) {
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else {
                ans=Math.min(nums[mid],ans);
                high=mid-1;
            }
        }
        return ans;
    }
}
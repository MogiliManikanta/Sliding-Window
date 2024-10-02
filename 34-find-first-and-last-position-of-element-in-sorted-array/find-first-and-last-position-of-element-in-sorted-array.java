class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums,target);
        int last = lastOccurence(nums,target);
        return new int[]{first,last};
    }
    public int firstOccurence(int[] nums, int target) {
        int ans=-1,low=0,high=nums.length-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid]==target) {
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else {
                high = mid -1;
            }
        }
        return ans;
    }
    public int lastOccurence(int[] nums,int target) {
        int ans =-1,low=0,high=nums.length-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                ans= mid;
                low=mid+1;
            }
            else if(nums[mid]<target) {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
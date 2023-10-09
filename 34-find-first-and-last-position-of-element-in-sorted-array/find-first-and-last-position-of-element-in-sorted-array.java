class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]=findFirstPosition(nums,target);
        result[1]=findLastPosition(nums,target);
        return result;
    }
    private int findFirstPosition(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{ // nums[mid]==target
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    private int findLastPosition(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{ // nums[mid]==target
                ans=mid;
                low=mid+1;
            }
        }
        return ans;
    }
}
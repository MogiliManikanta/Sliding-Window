class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstPositionHelper(nums,target);
        if(first==-1) return new int[]{-1,-1};
        int last=lastPositionHelper(nums,target);
        return new int[]{first,last};
    }
    public int firstPositionHelper(int[] nums,int target){
        int low=0,high=nums.length-1,first=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return first;
    }
    public int lastPositionHelper(int[] nums,int target){
        int low=0,high=nums.length-1,last=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return last;
    }
}
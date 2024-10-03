class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
       if(n==1) return nums[0];
       else if(nums[0]!=nums[1]) return nums[0];
       else if(nums[n-1]!=nums[n-2]) return nums[n-1];
       else {
            int low=1,high=n-2;
            while(low<=high) {
                int mid = low + (high - low)/2;
                if(nums[mid]!=nums[mid-1] && nums[mid+1] != nums[mid]) {
                    return nums[mid];
                }
                else if((mid%2 == 0 && nums[mid]==nums[mid+1]) ||
                  (mid%2==1 && nums[mid]==nums[mid-1])) {
                    low = mid+1;
                }
                else {
                    high=mid-1;
                } 
            }
       }
       return -1; 
    }
}
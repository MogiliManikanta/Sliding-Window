class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=n+m-1;
        int nums1Ind=m-1;
        int nums2Ind=n-1;
        while(nums2Ind>=0){
            if(nums1Ind>=0 && nums1[nums1Ind]>nums2[nums2Ind]){
                nums1[k]=nums1[nums1Ind];
                k--;
                nums1Ind--;
            }
            else{
                nums1[k--]=nums2[nums2Ind--];
            }
        }
    }
}
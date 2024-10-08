class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n>m) return findMedianSortedArrays(nums2,nums1);
        int low=0;
        int high=n;
        int left=(n+m+1)/2;
        while(low <= high) {
            int mid1 = (low + (high-low)/2);
            int mid2 = left-mid1;
            int leftElement1 = mid1>0 ? nums1[mid1-1] :Integer.MIN_VALUE;
            int rightElement1 = mid1<n?nums1[mid1] : Integer.MAX_VALUE;
            int leftElement2 = mid2>0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int rightElement2=mid2<m?nums2[mid2] : Integer.MAX_VALUE;
            if(leftElement1<=rightElement2 && leftElement2 <= rightElement1){
                if((m+n)%2==0) {
                     return (Math.max(leftElement1,leftElement2) + Math.min(rightElement1,rightElement2))/2.0;
                }
                else{
                    return Math.max(leftElement1,leftElement2);
                }
            }
            else if(leftElement1 < rightElement2) {
                low=mid1+1;
            }
            else{
                high=mid1-1;
            }
        }
        return 0.0;
    }
}
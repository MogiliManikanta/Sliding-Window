class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low=0;
        int high=n1;
        int left=(n1+n2+1)/2;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=(left-mid1);
            int leftElement1 = mid1-1>=0?nums1[mid1-1] : Integer.MIN_VALUE;
            int leftElement2 = mid2-1>=0?nums2[mid2-1] : Integer.MIN_VALUE;
            int rightElement1 = mid1<n1?nums1[mid1] :Integer.MAX_VALUE;
            int rightElement2 = mid2<n2?nums2[mid2] : Integer.MAX_VALUE;
            if(leftElement1<=rightElement2 && leftElement2<=rightElement1){
                if((n1+n2)%2==1) return (double) Math.max(leftElement1,leftElement2);
                else{
                         return (double)(Math.max(leftElement1,leftElement2)
                       + Math.min(rightElement1,rightElement2))/2.0;
                }
            }
            if(leftElement1>rightElement2) high=mid1-1;
            //leftElement2>rightElement1
            else low=mid1+1;
        }
        return 0;
    }
}
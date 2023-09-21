class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            int []temp=nums1;
            nums1=nums2;
            nums2=temp;
            int templength=m;
            m=n;
            n=templength;
        }
        int low=0;
        int high=m;
        int middlePosition=((n+m)+1)/2;
        while(low<=high){
            int cut1=(low+high)/2;
            int cut2=middlePosition-cut1;
            int l1=(cut1==0) ? Integer.MIN_VALUE: nums1[cut1-1];
            int l2=(cut2==0) ? Integer.MIN_VALUE: nums2[cut2-1];
            int r1=(cut1==m) ?  Integer.MAX_VALUE: nums1[cut1];
            int r2=(cut2==n) ?  Integer.MAX_VALUE: nums2[cut2];
            if((l1<=r2) && (l2<=r1)){
                if((m+n)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                high=cut1-1;
            }
            else{
                low=cut1+1;
            }
        }
        return 0.0;
    }
}
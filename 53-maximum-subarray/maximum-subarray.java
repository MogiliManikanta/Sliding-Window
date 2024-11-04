class Solution {
    public int maxSubArray(int[] nums) {
        int ansStart=-1,start=-1,ansEnd=-1,n=nums.length;
        int sum=0,maxi= - (int) 1e9;
        for(int i=0;i<n;i++){
            // if(sum==0){
            //     start=i;
            // }
            sum+=nums[i];
            
            if(sum>maxi){
                // ansStart=start;
                // ansEnd=i;
                maxi=sum;
            }
            if(sum<0) sum=0;
            
        }
        return maxi;
    }
}
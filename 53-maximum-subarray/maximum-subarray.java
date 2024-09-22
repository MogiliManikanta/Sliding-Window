class Solution {
    public int maxSubArray(int[] nums) {
        int ansStart=-1,ansEnd=-1,start=-1,sum=0,maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum==0){
                start=i;
            }
            sum+=nums[i];
            if(sum>maxi){
                ansStart=start;
                ansEnd=i;
                maxi=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }
}
/*class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        int sum=0;
        int maxi=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>maxi)
                maxi=sum;
            if(sum<0)
                sum=0;
        }
        return maxi;
    }
}
/***
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int total = 0;

        for (int i =0;i<nums.length;i++) {
            total += nums[i];
            sum = sum < total ? total : sum;
            if (total < 0) {
                total = 0;
            }
        }
        return sum;
    }
}


 */
 /**class Solution {
    public int maxSubArray(int[] nums) {
        //  int localMax = nums[0];
        // int globalMax = nums[0];

        // for (int i = 1; i < nums.length; i++) {
        //     localMax = Math.max(nums[i], localMax + nums[i]);
        //     if (localMax > globalMax) {
        //         globalMax = localMax;
        //     }
        // }
        // return globalMax;

        int sum = 0 ;
        int max = nums[0];
        for(int i : nums){
            sum += i;
            max = sum > max ? sum : max;
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
} */
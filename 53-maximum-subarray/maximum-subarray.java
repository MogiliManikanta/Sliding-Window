class Solution 
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
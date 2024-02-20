class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int sum = 0;
        int n = nums.length;
        int sum_ext = (n * (n+1))/2;
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
        }
        return sum_ext - sum;
    }
}
class Solution {
    public int maxSubArray(int[] arr) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;
        int n=arr.length;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
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
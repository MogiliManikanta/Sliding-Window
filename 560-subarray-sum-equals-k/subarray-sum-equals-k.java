class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, ans = 0;
        mp.put(sum, 1);
        for (int num : nums) {
            sum += num;
            int find = sum - k;
            if (mp.containsKey(find)) {
                ans += mp.get(find);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    } 
}
/**any idea guys, why do we have to initialize map like preSum.put(0, 1); .........I mean how would we know to do this if approaching this solution for first time? I got most of the things in for loop correct (ofc i had seen "two sum" problem, "Maximum Size Subarray Sum Equals k" under amazon problem before and used similar ideas here...)...still don't get why we initialize the map...

##################

I see ...After spending some time on the analysis, I found the reason behind having initialize preSum.put(0,1)....it is for those (sum - k) == 0 calculations which are valid subarrays but need to get counted. e.g. if k = 7 and sum = 7 (at second element for array is : 3, 4, 3, 8) at some iteration.....then sum - k = 0....this 0 will get counted in statement result += preSum.get(sum - k);

#############

So in conclusion, the initial entry preSum.put(0, 1) can be exchanged with statement :
if (sum == k) count++;
we can put it just below sum += nums[i]; statement. This will make code more intuitive...as we are trying to find the sum which matches to k! */
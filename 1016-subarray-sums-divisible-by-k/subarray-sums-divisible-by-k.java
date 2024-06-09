class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefix_map = new HashMap<>();
        prefix_map.put(0, 1);
        int sum = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if(sum < 0) sum += k;
            if(prefix_map.containsKey(sum)) {
                ans += prefix_map.get(sum);
                prefix_map.put(sum, prefix_map.get(sum) + 1);
            } else {
                prefix_map.put(sum, 1);
            }
        }
        return ans;
    }
}
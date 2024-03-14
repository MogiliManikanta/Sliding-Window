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
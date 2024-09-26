class Solution {
    // public int subarraysWithKDistinct(int[] nums, int k) {
    //     return atmost(nums, k) - atmost(nums, k-1);
    // }
    
    // private int atmost(int[] nums, int k) {
    //     Map<Integer, Integer> m = new HashMap<>();
    //     int start = 0;
    //     int ans = 0;
    //     for(int end=0; end<nums.length; end++) {
    //         m.put(nums[end], m.getOrDefault(nums[end], 0) + 1);
    //         while (m.size() > k) {
    //             int tmp = m.get(nums[start]);
    //             if (tmp==1) m.remove(nums[start++]);
    //             else m.put(nums[start++], tmp-1);
    //         }
    //         ans += (end-start+1);
    //     }
    //     return ans;
    // }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] frq = new int[nums.length+1];
        int start = 0, curr = 0, ans = 0;
        for(int end=0; end<nums.length; end++) {
            if (frq[nums[end]]++ == 0) k--;
            while (k<0) {
               --frq[nums[start++]];
               k++;
               curr = 0;
            }
            if (k==0) {
                while(frq[nums[start]] > 1) {
                    --frq[nums[start++]];
                    curr++;
                }
                ans += curr + 1;
            }
        }
        return ans;
    }
}
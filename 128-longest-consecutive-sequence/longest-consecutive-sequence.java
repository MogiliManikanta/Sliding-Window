class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int cnt=0,maxi=1;
        int n = nums.length;
        for(int i : set) {
            int previous = i-1;
            if(!set.contains(previous)) {
                int x = i+1;
                cnt=1;
                while(set.contains(x)) {
                    x++;
                    cnt++;
                    maxi=Math.max(maxi,cnt);
                }
            }
        }
        return maxi;
    }
}
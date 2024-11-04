class Solution {
    public int longestConsecutive(int[] nums) {
        int longest=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        for(int i : nums){
            if(!set.contains(i-1)){
                int cnt=0;
                int x=i;
                while(set.contains(x)){
                    x=x+1;
                    cnt++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
}
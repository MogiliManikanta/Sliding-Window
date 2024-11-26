class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longest=0;
        for(int ele : set){
           if(!set.contains(ele-1)){
            int cnt=0;
            int x=ele;
            while(set.contains(x)){
                    cnt++;
                    x++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
}
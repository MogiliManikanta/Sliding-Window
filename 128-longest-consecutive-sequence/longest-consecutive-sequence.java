class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int it : set){
            if(!(set.contains(it-1))){
                int cnt=1;
                int x=it;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}
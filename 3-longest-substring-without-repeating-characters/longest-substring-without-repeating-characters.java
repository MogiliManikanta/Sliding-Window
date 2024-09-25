class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        if(s.length()==0) return 0;
        int left=0,right=0,len=s.length(),maxi=Integer.MIN_VALUE;
        while(right<len){
            if(set.contains(s.charAt(right))){
                while(left<right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            maxi=Math.max(maxi,right-left+1);
            ++right;
        }
        return maxi;
    }
}
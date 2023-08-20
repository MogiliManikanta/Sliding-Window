class Solution {
    public int longestSubstring(String s, int k) {
        int[] frequency = new int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
        }
        boolean valid=true;
        int left=0,start=0,result=Integer.MIN_VALUE;
        for(int right=0;right<s.length();right++){
            if(frequency[s.charAt(right)-'a']<k){
                result=Math.max(result,longestSubstring(s.substring(left,right),k));
                valid=false;
                left=right+1;
            }
        }
        return valid?s.length():Math.max(result,longestSubstring(s.substring(left),k));
    }
}
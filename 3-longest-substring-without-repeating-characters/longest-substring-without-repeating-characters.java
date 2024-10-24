/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if(set.contains(ch)){
                    break;
                }
                set.add(ch);
                maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
}*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map = new HashMap<>();
        int left=0,right=0,maxi=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                // left = Math.max(map.get(s.charAt(right))+1,left); this will also right
                int temp=map.get(s.charAt(right));
                if(temp>=left){
                    left=temp+1;
                }
           }
           maxi=Math.max(maxi,right-left+1);
           map.put(s.charAt(right),right);
           right++;
        }
        return maxi;
    }
}
/**
 * class Solution {
 * public int lengthOfLongestSubstring(String s) {
 * Set<Character> set = new HashSet<>();
 * if(s.length()==0) return 0;
 * int left=0,right=0,len=s.length(),maxi=Integer.MIN_VALUE;
 * while(right<len){
 * if(set.contains(s.charAt(right))){
 * while(left<right && set.contains(s.charAt(right))){
 * set.remove(s.charAt(left));
 * left++;
 * }
 * }
 * set.add(s.charAt(right));
 * maxi=Math.max(maxi,right-left+1);
 * ++right;
 * }
 * return maxi;
 * }
 * }
 */
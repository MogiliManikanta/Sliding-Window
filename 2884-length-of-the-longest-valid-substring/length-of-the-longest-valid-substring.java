class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String>set = new HashSet<>();
        int maxLenForbidden = Integer.MIN_VALUE;
        for(String temp : forbidden){
            set.add(temp);
            maxLenForbidden = Math.max(maxLenForbidden,temp.length());
        }
        int left=0,right=0;
        int longest=Integer.MIN_VALUE;
        while(right<word.length()){
            String temp="";
            for(int i=right;i>=left && i>(right-maxLenForbidden);i--){
                temp=word.charAt(i)+temp;
                if(set.contains(temp)){
                    left=i+1;
                    break;
                }
            }
            right++;
            longest=Math.max(longest,right-left);
        }
        return longest;
    }
}
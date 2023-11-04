class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()<=k){
            return s.length();
        }
        HashMap<Character,Integer>map = new HashMap<>();
        int left=0,result=0;
        int maxCount=0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxCount = Math.max(maxCount,map.get(s.charAt(right)));
            while(right-left+1-k>maxCount){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
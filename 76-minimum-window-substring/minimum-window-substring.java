class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int start=0,end=0,minLength=Integer.MAX_VALUE,counter=t.length(),minStart=0;
        while(end<s.length()){
            char endChar = s.charAt(end);
            if(freq[endChar]>0){
                counter--;
            }
            freq[endChar]--;
            end++;
            while(counter==0){
                if(minLength>end-start){
                    minLength=end-start;
                    minStart=start;
                }
                char startChar = s.charAt(start);
                freq[startChar]++;
                if(freq[startChar]>0){
                    counter++;
                }
                start++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minLength+minStart);
    }
}
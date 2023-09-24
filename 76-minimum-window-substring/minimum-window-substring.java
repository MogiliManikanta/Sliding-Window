class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }

        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int start=0,end=0,minLen=Integer.MAX_VALUE,minStart=0;
        int counter=t.length();
        while(end<s.length()){
            char endChar = s.charAt(end);
            
            if(freq[endChar]>0){
                counter--;
            }
            freq[endChar]--;
            end++;
            while(counter==0){
                if(minLen>end-start){
                    minLen=end-start;
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
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minLen+minStart);
    }
}
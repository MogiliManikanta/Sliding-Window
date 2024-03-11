class Solution {
    public String customSortString(String order, String s) {
        int frequency[] = new int[26];
        String finalresult="";
        String result="";
        for(char c : order.toCharArray()){
            frequency[c-'a']++;
        }
        for(char c : s.toCharArray()){
            if(frequency[c-'a']==0){
                result+=c;
                //frequency[c-'a']++;
            }
            else{
                frequency[c-'a']++;
            }
        }
        for(char c : order.toCharArray()){
            while(frequency[c-'a']>1){
                finalresult+=c;
                frequency[c-'a']--;
            }
        }
        return finalresult+result;
    }
}
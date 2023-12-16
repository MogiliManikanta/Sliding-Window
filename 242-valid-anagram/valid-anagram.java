class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int frequency[] = new  int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            frequency[t.charAt(i)-'a']--;
        }
        for(int i : frequency){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
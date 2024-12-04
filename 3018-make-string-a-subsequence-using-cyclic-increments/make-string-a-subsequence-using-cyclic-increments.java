class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char s1[] = str1.toCharArray();
        char s2[] = str2.toCharArray();
        if(s2.length>s1.length){
            return false;
        }
        int t=0;
        for(int i=0;i<s1.length && t<s2.length;i++){
            if(s1[i]==s2[t]){
                t++;
            }
            else if(((s1[i]-'a')+1)%26 + 'a' ==s2[t]){
                t++;
            }
        }
        return t==s2.length;
    }
}
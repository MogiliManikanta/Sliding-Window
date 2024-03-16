class Solution {
    public int expressiveWords(String s, String[] words) {
        if(s==null || words==null){
            return 0;
        }
        int count=0;
        for(String S : words){
            if(strechy(s,S)){
                count++;
            }
        }
        return count;
    }
    public boolean strechy(String s,String word){
        if(s==null || word==null){
            return false;
        }
        int i=0,j=0;
        while(i<s.length() && j<word.length()){
            if(s.charAt(i)==word.charAt(j)){
                int len1 = getRepeatedLength(s,i);
                int len2 = getRepeatedLength(word,j);
                if((len1<3 && len1!=len2) || (len1>=3 &&len1<len2)){
                    return false;
                }
                i+=len1;
                j+=len2;
            }else{
                return false;
            }
        }
        return i==s.length() && j==word.length();
    }
    public int getRepeatedLength(String s,int i){
        int j=i;
        while(j<s.length() && s.charAt(j)==s.charAt(i)){
            j++;
        }
        return j-i;
    }
}
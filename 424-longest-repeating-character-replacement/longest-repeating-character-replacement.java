class Solution {
    public int characterReplacement(String s, int k) {
        int maxi=0,maxFreq=0;
        for(int i=0;i<s.length();i++){
            int[] letters = new int[26];
            for(int j=i;j<s.length();j++){
                letters[s.charAt(j)-'A']++;
                 maxFreq=Math.max(maxFreq,letters[s.charAt(j)-'A']);
                 if(j-i+1-(maxFreq)>k){
                    break;
                 }
                 else{
                    maxi=Math.max(maxi,j-i+1);
                 }
            }
        }
        return maxi;
    }
}
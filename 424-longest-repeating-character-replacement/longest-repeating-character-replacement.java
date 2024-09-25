class Solution {
    public int characterReplacement(String s, int k) {
        int letters[] = new int[26];
        int left=0,right=0,maxi=0,maxFreq=0;
        while(right<s.length()){
            letters[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,letters[s.charAt(right)-'A']);
            if(right-left+1-(maxFreq)>k){
                while(right-left+1-(maxFreq)>k){
                    letters[s.charAt(left)-'A']--;
                    for(int i=0;i<26;i++){
                        maxFreq=Math.max(maxFreq,letters[i]);
                    }
                    left++;
                }
            }
            if(right-left+1-(maxFreq)<=k){
                maxi=Math.max(right-left+1,maxi);
            }
            right++;
        }
        return maxi;
    }
}
/*class Solution {
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
}*/
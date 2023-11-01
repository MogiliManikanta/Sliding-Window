class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(String dictionaryWord: wordDict){
                
                int lengthOfWord = dictionaryWord.length();
                
                if (lengthOfWord <= i) {
                    
                    boolean canMakeWordUpToThisPoint = f[ i - lengthOfWord ];
                    
                    if (canMakeWordUpToThisPoint) {
                        
                        String substringContinuedFromLastCompleteWord = s.substring(i - dictionaryWord.length(), i);
                        
                        if (substringContinuedFromLastCompleteWord.equals(dictionaryWord)) {
                            f[i] = true; // Can make a word from the last point to here
                            break; // No need to look at more words, we found a continuation
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }

}
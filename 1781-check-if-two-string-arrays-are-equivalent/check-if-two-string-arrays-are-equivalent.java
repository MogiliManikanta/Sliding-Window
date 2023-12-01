class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int arrIndex1=0,arrIndex2=0;
        int charIndex1=0,charIndex2=0;
        while(arrIndex1<word1.length && arrIndex2 < word2.length){
            if(word1[arrIndex1].charAt(charIndex1)!=word2[arrIndex2].charAt(charIndex2)){
                return false;
            }
            charIndex1++;
            charIndex2++;
            if(charIndex1==word1[arrIndex1].length()){
                charIndex1=0;
                arrIndex1++;
            }
            if(charIndex2==word2[arrIndex2].length()){
                charIndex2=0;
                arrIndex2++;
            }
        }
        return arrIndex1==word1.length && arrIndex2==word2.length;
    }
}
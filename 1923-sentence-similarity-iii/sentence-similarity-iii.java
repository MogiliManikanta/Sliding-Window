class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String shortSentence[] = sentence1.split(" ");
        String longSentence[] = sentence2.split(" ");
        int shortlength = shortSentence.length;
        int longlength = longSentence.length;
        if(shortlength>longlength){
            return areSentencesSimilar(sentence2,sentence1);
        }
        int i=0;
        int matchCount=0;
        while(i<shortlength && shortSentence[i].equals(longSentence[i])){
            i++;
            matchCount++;
        }
        while(i<shortlength && shortSentence[i].equals(longSentence[longlength-(shortlength-i)])){
            i++;
            matchCount++;
        }
        return matchCount==shortlength;
    }
}
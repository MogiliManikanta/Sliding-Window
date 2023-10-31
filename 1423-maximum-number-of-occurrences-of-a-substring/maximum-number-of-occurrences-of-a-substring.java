class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    HashMap<String, Integer> map = new HashMap<>();
    int maxOccurrence = 0;
    
    for (int i = 0; i < s.length(); i++) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        int distinctLetters = 0;
        
        for (int j = i; j < s.length() && j - i + 1 <= maxSize; j++) {
            char c = s.charAt(j);
            
            if (!letterCount.containsKey(c)) {
                distinctLetters++;
            }
            
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            
            if (distinctLetters > maxLetters) {
                break;
            }
            
            if (j - i + 1 >= minSize) {
                String substring = s.substring(i, j + 1);
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                maxOccurrence = Math.max(maxOccurrence, map.get(substring));
            }
        }
    }
    
    return maxOccurrence;
}

}
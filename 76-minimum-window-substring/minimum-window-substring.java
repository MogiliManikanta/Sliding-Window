class Solution {
    public String minWindow(String input, String pattern) {
    int[] frequencyMap = new int[128];
    for (char c : pattern.toCharArray()) frequencyMap[c]++;
    
    int remainingChars = pattern.length(), start = 0, end = 0, minWindowSize = Integer.MAX_VALUE, minWindowStart = 0;
    
    while (end < input.length()) {
        if (frequencyMap[input.charAt(end++)]-- > 0) remainingChars--;
        
        while (remainingChars == 0) {
            if (end - start < minWindowSize) {
                minWindowSize = end - start;
                minWindowStart = start;
            }
            
            if (frequencyMap[input.charAt(start++)]++ == 0) remainingChars++;
        }
    }
    
    return minWindowSize == Integer.MAX_VALUE ? "" : input.substring(minWindowStart, minWindowStart + minWindowSize);
}

}
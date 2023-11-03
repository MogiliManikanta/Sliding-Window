class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(s == null || s.length() == 0 || maxLetters == 0) return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for(int i = 0; i < s.length() - minSize + 1; i++) {
            String cur = s.substring(i, i + minSize);
            if(isValid(cur, maxLetters)) {
                hm.put(cur, hm.getOrDefault(cur, 0) + 1);
                max = Math.max(max, hm.get(cur));
            }
        }
        return max;
    }
	
    boolean isValid(String cur, int maxLetters) {
		// length of cur  = minSize and makes this method run O(1)
        HashSet<Character> hs = new HashSet<>();
        for(char c: cur.toCharArray()) hs.add(c);
        return hs.size() <= maxLetters;
    }
}
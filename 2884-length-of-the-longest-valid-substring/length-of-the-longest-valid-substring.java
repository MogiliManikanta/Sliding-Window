class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
       int maxLen = 0;
        Set<String> st = new HashSet<>();
        for (String s : forbidden) {
            st.add(s);
            maxLen = Math.max(maxLen, s.length());
        }

        int n = word.length();
        int ans = 0;
        int l = 0, r = 0;
        while (r < n) {
            String temp = "";
            for (int i = r; (i >= l) && (i > r - maxLen); i--) {
                temp = word.charAt(i) + temp;
                if (st.contains(temp)) {
                    l = i + 1;
                    break;
                }
            }
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans; 
    }
}
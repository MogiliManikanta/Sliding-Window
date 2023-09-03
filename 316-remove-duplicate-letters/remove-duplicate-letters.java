public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Integer> mp = new HashMap<>();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mp.put(c, mp.get(c) - 1);
            if (!visited[c - 'a']) {
                while (!st.isEmpty() && st.peek() > c && mp.get(st.peek()) > 0) {
                    visited[st.peek() - 'a'] = false;
                    st.pop();
                }
                st.push(c);
                visited[c - 'a'] = true;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}

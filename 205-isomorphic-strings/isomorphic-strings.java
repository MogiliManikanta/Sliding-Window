class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(); // Calculate the length of the input strings s and t.
        HashMap<Character, Character> map = new HashMap<>(); // Create a HashMap to store character mappings.

        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) { // If the map already contains the character from string s.
                if (map.get(s.charAt(i)) != t.charAt(i)) { // If the character mapping does not match the character in
                                                           // string t.
                    return false; // Return false as the strings are not isomorphic.
                }
            } else {
                if (map.containsValue(t.charAt(i))) { // If the character from string t is already mapped to a different
                                                      // character.
                    return false; // Return false as the strings are not isomorphic.
                }
            }
            map.put(s.charAt(i), t.charAt(i)); // Add the character from string s to string t as a mapping in the
                                               // HashMap.
        }
        return true; // If the loop completes without finding any non-isomorphic mappings, return
                     // true.
    }
}

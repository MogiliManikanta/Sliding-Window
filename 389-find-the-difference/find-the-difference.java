class Solution {
    public char findTheDifference(String s, String t) {
        int charCode = 0;
        // Iterate through both strings and XOR char codes
        for (int i = 0; i < s.length(); ++i) {
            charCode ^= (int)s.charAt(i);
            charCode ^= (int)t.charAt(i);
        }
        // XOR the last character of t
        charCode ^= (int)t.charAt(t.length() - 1);
        return (char)charCode;
    }
}

class Solution {
    public int minLength(String s) {
        boolean removed = true;

        while (removed) {
            removed = false;
            int i = 0;

            while (i < s.length() - 1) {
                if (s.substring(i, i + 2).equals("AB") || s.substring(i, i + 2).equals("CD")) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    removed = true;
                } else {
                    i++;
                }
            }
        }

        return s.length();
    }
}
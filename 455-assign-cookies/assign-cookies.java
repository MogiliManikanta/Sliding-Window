import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int l = 0, r = 0;
        
        while (l < n && r < m) {
            if (s[r] >= g[l]) {
                // If this cookie satisfies the child, increment both pointers.
                l++;
            }
            // Always move to the next cookie.
            r++;
        }
        
        return l;  // Return the number of children that can be satisfied.
    }
}

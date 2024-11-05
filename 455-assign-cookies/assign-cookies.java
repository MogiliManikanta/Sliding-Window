class Solution {
    public int findContentChildren(int[] greed, int[] cookieSize) {
        // Get the size of
        // the greed array
        int n = greed.length;

        // Get the size of
        // the cookieSize array
        int m = cookieSize.length;

        // Sort the greed factors in ascending
        // order to try and satisfy the
        // least greedy children first
        Arrays.sort(greed);

        // Sort the cookie sizes in ascending
        // order to use the smallest cookies first
        Arrays.sort(cookieSize);

        // Initialize a pointer for the
        // cookieSize array, starting
        // from the first cookie
        int l = 0;

        // Initialize a pointer for the
        // greed array, starting from
        // the first child
        int r = 0;

        // Iterate while there are
        // cookies and children
        // left to consider
        while (l < m && r < n) {
            // If the current cookie can
            // satisfy the current child's greed
            if (greed[r] <= cookieSize[l]) {
                // Move to the next child,
                // as the current child is satisfied
                r++;
            }
            // Always move to the next cookie
            // whether the current child
            // was satisfied or not
            l++;
        }

        // The value of r at the end of
        // the loop represents the number
        // of children that were satisfied
        return r;
    }
}

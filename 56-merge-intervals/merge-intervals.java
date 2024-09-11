class Solution {
    public int[][] merge(int[][] intervals) {
        // Sorting intervals by their starting value
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
    // If merged list is empty or current interval doesn't overlap with the last one in merged
    if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
        // Add current interval to merged list
        merged.add(interval);
    } else {
        // There is an overlap, merge the intervals by extending the end of the last interval in merged
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
    }
}

        
        return merged.toArray(new int[merged.size()][]);
    }
}

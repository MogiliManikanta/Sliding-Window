class Solution {
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> {
            if (l[1] != r[1]) {
                return Integer.compare(l[1], r[1]);
            } else {
                return Integer.compare(r[0], l[0]);
            }
        });

        int count = 2;
        int head = intervals[0][1] - 1;
        int tail = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] <= head) {
                continue;
            } else if (interval[0] <= tail) {
                head = tail;
                tail = interval[1];
                count++;
            } else {
                head = interval[1] - 1;
                tail = interval[1];
                count += 2;
            }
        }

        return count;
    }
}
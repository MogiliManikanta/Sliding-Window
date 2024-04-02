class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals){
            if(i[0] <= end){ // overlap
                end = Math.max(end,i[1]);
            }
            else{ // no overlap
                result.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][2]);
    }
}
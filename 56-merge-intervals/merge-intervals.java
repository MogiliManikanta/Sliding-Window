class Solution {
    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, new Comparator<int[]>(){
        //     public int compare(int[]a ,int[]b){
        //         return a[0]-b[0];
        //     }
        // });

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(result.isEmpty() || result.get(result.size()-1)[1]<start){
                result.add(interval);
            }else{
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],end);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
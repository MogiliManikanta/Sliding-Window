class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1,int []i2){
                return i1[0]-i2[0];
            }
        });
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end   = intervals[i][1];
            if(list.size()==0 || list.get(list.size()-1)[1]<start){
                list.add(new int[]{start,end});
            }
            else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],end);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
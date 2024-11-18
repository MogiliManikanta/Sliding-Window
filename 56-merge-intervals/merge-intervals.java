class Solution {
    public int[][] merge(int[][] intervals) {
       List<int[]> list = new ArrayList<>();
       Arrays.sort(intervals, new Comparator<int[]>(){
        public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }
       });
    //   Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        for(int[] i : intervals ){
            int start = i[0];
            int end = i[1];
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
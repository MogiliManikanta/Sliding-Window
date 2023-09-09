class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target){
            return 0;
        }
        PriorityQueue<Integer>queue = new PriorityQueue<>((a,b)->b-a);
        int index =0,n=stations.length,stops=0,maxDistance=startFuel;
        while(maxDistance<target){
            while(index<n && stations[index][0] <= maxDistance){
                queue.offer(stations[index++][1]);
            }
            if(queue.isEmpty()){
                return -1;
            }
            maxDistance+=queue.poll();
            stops++;
        }
        return stops;
    }
}
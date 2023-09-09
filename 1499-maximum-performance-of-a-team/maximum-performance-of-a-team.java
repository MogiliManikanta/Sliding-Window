class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)(1e9+7);
        int[][] engineers = new int[n][2];
        for(int i=0;i<n;i++){
            engineers[i] = new int[] {efficiency[i],speed[i]};
        }
        Arrays.sort(engineers,(a,b) -> b[0] - a[0]);
        PriorityQueue<Integer>queue = new PriorityQueue<>((a,b)->(a-b));
        long res = Long.MIN_VALUE,totalSpeed=0;
        for(int[] engineer : engineers){
            if(queue.size()==k){
                totalSpeed -= queue.poll();
            }
            queue.add(engineer[1]);
            totalSpeed = (totalSpeed+engineer[1]);
            res = Math.max(res,(totalSpeed * engineer[0]));
        }
        return (int)(res%mod);
    }
}
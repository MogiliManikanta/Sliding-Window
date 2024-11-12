class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int itemslength = items.length;
        int querieslength = queries.length;
        Arrays.sort(items,(a,b)-> a[0]-b[0]);
        int prefixSum[] = new int[itemslength];
        Arrays.fill(prefixSum,0);
        prefixSum[0]=items[0][1];
        for(int i=1;i<itemslength;i++){
            prefixSum[i]=Math.max(prefixSum[i-1],items[i][1]);
        }
        int[] result = new int[queries.length];
        Arrays.fill(result,0);
        for(int i=0;i<queries.length;i++){
            int curr=queries[i];
            int low=0;
            int high=items.length-1;
            int profit=-1;
            while(low<=high){
                int mid = (low+(high-low)/2);
                if(items[mid][0]>curr){
                    high=mid-1;
                }
                else{
                    profit=mid;
                    low=mid+1;
                }
            }
            if(profit==-1){
                continue;
            }
            else{
                result[i]=prefixSum[profit];
            }
        }
        return result;
    }
}
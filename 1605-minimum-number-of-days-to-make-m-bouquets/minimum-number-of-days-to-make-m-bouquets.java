class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n <m * k) return -1;
        int low=(int)1e9,high=-(int)1e9;
        for(int i=0;i<n;i++) {
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        low=1;
        int ans=-1;
        while(low<=high) {
            int mid = (low+(high-low)/2);
            if(possible(mid,bloomDay,m,k)) {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int[] bloomDay,int m,int k) {
        int noOfBouqes=0;
        int cnt=0;
        for(int i=0;i<bloomDay.length;i++){
            if(mid>=bloomDay[i]) {
                cnt++;
            }
            else{
                noOfBouqes += cnt/k;
                cnt=0;
            }
        }
        noOfBouqes+=cnt/k;
        return noOfBouqes>=m;
    }
}
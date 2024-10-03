class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=-(int)1e9;
        for(int i=0;i<piles.length;i++) {
            high=Math.max(high,piles[i]);
        }
        int low=1;
        int ans=0;
        while(low<=high) {
            int mid = (low + (high-low)/2);
            if(possible(mid,piles,h)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int[] piles,long hrs) {
        long cntHrs=0;
        for(int i=0;i<piles.length;i++) {
            cntHrs += (piles[i]+mid-1)/mid;
        }
        return cntHrs<=hrs;
    }
}
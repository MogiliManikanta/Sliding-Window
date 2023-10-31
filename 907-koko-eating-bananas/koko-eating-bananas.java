class Solution {
    boolean isPossible(int []piles ,int h ,int k){
        int total=0;

        for(int i=0;i<piles.length;i++) total+=Math.ceil((double)piles[i]/k);

        return total<=h ;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=Integer.MIN_VALUE;

        for(int i=0;i<piles.length;i++) maxPile=Math.max(maxPile,piles[i]);

        int l=1;
        int r=maxPile;
        //k will lie between 1 and maxPile as we need min val of k above maxPile we dont get min value of k
        while(l<=r){
          int mid=l+(r-l)/2;
          if(isPossible(piles,h,mid)){
           r=mid-1;
          }
          else l=mid+1;
        }

        return l;
    }
}
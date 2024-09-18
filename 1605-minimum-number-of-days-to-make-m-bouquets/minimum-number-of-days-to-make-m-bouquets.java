class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val=m*k;
        long size=bloomDay.length;
        if(size<val) return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(helperFunction(mid,m,k,bloomDay)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean helperFunction(int mid,int m,int k,int[] bloomDay){
        int cnt=0;
        int noOfBouques =0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                cnt++;
            }
            else{
                noOfBouques +=(cnt/k); 
                cnt=0;
            }
        }
        noOfBouques+=(cnt/k);
        return noOfBouques>=m;
    }
}
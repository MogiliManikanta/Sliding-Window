class Solution {
    public int maxHelperFunction(int[] arr,int h){
        int n=arr.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(arr[i],maxi);
        }
        return maxi;
    }
    public int helperFunction(int mid,int[] piles,int hours){
        int ans=0,n=piles.length;
        for(int i=0;i<n;i++){
            ans += Math.ceil((double)piles[i]/(double)mid);
            if(ans>hours) return -1;
        }
        return 1;
    } 
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
         int ans=0;
        int high = maxHelperFunction(piles,h);
        while(low<=high){
           
            int mid = (low+(high-low)/2);
            int temp = helperFunction(mid,piles,h);
            if(temp==1){
                ans=mid;
            high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
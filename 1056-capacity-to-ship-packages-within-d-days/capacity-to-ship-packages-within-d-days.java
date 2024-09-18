class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int sum=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            low=Math.max(weights[i],low);
            sum+=weights[i];
        }
        int high=sum;
        int ans=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(possible(mid,weights,days)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int[] weights,int days){
        int load=0;
        int noOfDays=1;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>mid){
                noOfDays++;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        // System.out.println(noOfDays);
        return noOfDays<=days;
    }
}
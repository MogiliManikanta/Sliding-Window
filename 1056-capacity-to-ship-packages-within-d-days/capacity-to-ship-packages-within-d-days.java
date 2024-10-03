class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=-(int)1e9,sum=0;
        for(int i : weights) {
            low = Math.max(low,i);
            sum+=i;
        }
        // low=1;
        int high=sum;
        int ans=0;
        while(low <= high) {
            int mid = (low+(high-low)/2);
            if(possible(mid,weights,days)) {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int[] weights,int days) {
        int noOfDays=1,sum=0;
        for(int i=0;i<weights.length;i++) {
            if(sum+weights[i]<=mid) {
                sum+=weights[i];
            }
            else{
                noOfDays++;
                sum=weights[i];
            }
        }
        return noOfDays<=days;
    }
}
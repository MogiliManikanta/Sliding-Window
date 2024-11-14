class Solution {
    public boolean check(int mid,int[] quantities,int stores){
        int storeCount=0;
        for(int i : quantities){
            storeCount+=i/mid;
            if(i%mid!=0){
                storeCount+=1;
            }
        }
        return storeCount<=stores;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i : quantities){
            high=Math.max(high,i);
        }
        int result=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(check(mid,quantities,n)){
                result=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return result;
    }
}
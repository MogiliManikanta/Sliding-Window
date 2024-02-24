class Solution {
    public int mySqrt(int x) {
        long low=0;
        long high=x;
        //long mid;
        long result=-1;
        while(low<=high){
           long mid=(low+(high-low)/2);
            if(mid*mid==x){
                result=mid;
                return (int)result;
                //break;
            }
            else if(mid*mid<x){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)result;
    }
}
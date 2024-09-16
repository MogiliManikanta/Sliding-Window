class Solution {
    public int findMin(int[] arr) {
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    ans=arr[low];
                }
                low=mid+1;
            }else{
                if(ans>arr[mid]){
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        return ans;
    }
}
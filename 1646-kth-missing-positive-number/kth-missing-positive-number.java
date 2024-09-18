class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            int missing = arr[mid]-(mid+1);
            if(missing<k) low=mid+1;
            else high=mid-1;
        }
        return high+1+k;
        // arr[high]+more
        // more = k-missing
        // missing=arr[high]-(high-1)
        // arr[high]+k-missing
        // arr[high]+k-arr[high]+high+1
        // k+high+1
        // k+low
    }
    // arr =[4,7,9]
    // high=points to -1
    // so high might not be our answer
    // [2,3,4,7,11] k=5
    // high=7 but our answer is 9 so we need arr[high]+more
    // lies in between 

}
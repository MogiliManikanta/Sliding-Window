class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int low = 0,high=arr.length-1-k;
       while(low<=high){
           int mid = low+(high-low)/2;
           if(x-arr[mid] <= arr[mid+k]-x){
               high=mid-1;
           }
           else{
                low=mid+1;
           }
       }
       List<Integer> result = new ArrayList<>();
       for(int i=low;i<low+k;i++){
           result.add(arr[i]);
       }
       return result; 
    }
}
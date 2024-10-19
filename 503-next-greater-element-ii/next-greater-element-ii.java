class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            result[i] = -1;
            for(int j=i+1;j<=i+n-1;j++) {
                if(arr[j%n]>arr[i]){
                    result[i]=arr[j%n];
                    break;
                }
            }
        }
        return result;
    }
}
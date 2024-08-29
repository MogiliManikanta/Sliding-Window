class Solution {
    public boolean check(int[] arr) {
        int n=arr.length;
        int drop=0;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]) drop++;
        }
        if(drop==0) return true;
        else if(drop==1 && arr[0]>=arr[n-1]) return true;
        return false;
    }
}
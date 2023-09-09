class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfleft = new int[n];
        int[] minOfRight = new int[n];
        maxOfleft[0] = arr[0];
        for(int i=1;i<n;i++){
            maxOfleft[i] = Math.max(maxOfleft[i-1],arr[i]);
        }
        minOfRight[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            minOfRight[i] = Math.min(minOfRight[i+1],arr[i]);
        }
        int result = 0;
        for(int i=0;i<n-1;i++){
            if(maxOfleft[i]<=minOfRight[i+1]){
                result++;
            }
        }
        return result+1;
    }
}
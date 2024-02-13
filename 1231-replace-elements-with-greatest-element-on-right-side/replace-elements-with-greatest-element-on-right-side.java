class Solution {
    public int[] replaceElements(int[] arr) {
        int max=-1;
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int temp = arr[i];
            arr[i]=max;
            max=Math.max(max,temp);
        }
        return arr;
    }
}
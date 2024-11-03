class Solution {
    public int removeDuplicates(int[] arr) {
        int n=arr.length;
         int index=0;
        for(int i=1;i<n;i++){
            if(arr[index]!=arr[i]){
                arr[++index]=arr[i];
            }
        }
        return index+1;
    }
}
// [0,0,1,1,1,2,2,3,3,4]
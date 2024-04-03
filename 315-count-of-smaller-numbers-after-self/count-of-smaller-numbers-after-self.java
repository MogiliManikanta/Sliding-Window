class Solution {
    int count[];
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int originalIndex[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            originalIndex[i]=i;
        }
        count=new int[nums.length];
        sort(nums,originalIndex,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            result.add(count[i]);
        }
        return result;
    }
    public void sort(int[] arr,int[] originalIndex,int low,int high){
        if(low<high){
            int mid=(low+(high-low)/2);
            sort(arr,originalIndex,low,mid);
            sort(arr,originalIndex,mid+1,high);
            merge(arr,originalIndex,low,mid,high);
        }
    }
    public void merge(int[] arr,int[] originalIndex,int left,int mid,int right){
        int leftArrSize = mid-left+1;
        int rightArrSize = right-mid;
        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];
        for(int i=0;i<leftArrSize;i++){
            leftArr[i]=originalIndex[left+i];
        }
        for(int i=0;i<rightArrSize;i++){
            rightArr[i]=originalIndex[i+mid+1];
        }
        int i=0,j=0,k=left;
        int rightCount=0;
        while(i<leftArrSize && j<rightArrSize){
            if(arr[leftArr[i]]<=arr[rightArr[j]]){
                originalIndex[k]=leftArr[i];
                count[leftArr[i]]+=rightCount;
                i++;
            }
            else{
                originalIndex[k]=rightArr[j];
                rightCount++;
                j++;
            }
            k++;
        }
        while(i<leftArrSize){
            originalIndex[k]=leftArr[i];
            count[leftArr[i]]+=rightCount;
            i++;
            k++;
        }
        while(j<rightArrSize){
            originalIndex[k]=rightArr[j];
            j++;
            k++;
        }
    }
}
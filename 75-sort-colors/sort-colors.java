class Solution {
     public void sortColors(int[] nums) {
        int n=nums.length;
        int low =0;
        int  mid=0;
        int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
                /*
                    0 0 0 0 0 0 0 0 1 1 1 2 2 2 2
                                    l   h m
                
                 */
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    public  void swap(int[] nums,int  i,int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
     }
}
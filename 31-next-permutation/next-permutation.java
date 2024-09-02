class Solution {
    public void nextPermutation(int[] nums) {
        int index1=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1=i;
                break;
            }
        }
        if(index1==-1){
            reverse(nums,0,n-1);
            return;
        }
        int index2=-1;
        for(int i=n-1;i>=index1;i--){
            if(nums[i]>nums[index1]){
                swap(nums,index1,i);
                index2=i;
                break;
            }
        }
        reverse(nums,index1+1,n-1);
        return;
    }
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
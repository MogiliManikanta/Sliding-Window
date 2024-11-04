class Solution {
    public void nextPermutation(int[] nums) {
        int index1=-1;
        int index2=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1=i;
                break;
            }
        }
        if(index1==-1){
            reverse(nums,0);
            return;
        }
        for(int i=n-1;i>index1;i--){
            if(nums[i]>nums[index1]){
                index2=i;
                break;
            }
        }
        swap(nums,index1,index2);
        reverse(nums,index1+1);
    }
    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public void reverse(int[] nums,int left){
        int right=nums.length-1;
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] =temp;
            left++;
            right--;
        }
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k<0){
            k+=n;
        }
        k%=n;
        reverse(0,n-1,nums);
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
    }
    public void reverse(int left,int right, int[] nums){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
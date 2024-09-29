class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int n=nums.length;
        if(k<0){
            k+=nums.length;
        }
        // 7 6 5 4 3 2 1
        reverse(0,n-1,nums);
        //5 6 7 4 3 2 1
        reverse(0,k-1,nums);
        //5 6 7 1 2 3 4
        reverse(k,n-1,nums);
    }
    public void reverse(int left,int right,int[] nums){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
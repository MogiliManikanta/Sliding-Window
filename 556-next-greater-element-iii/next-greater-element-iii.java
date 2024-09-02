class Solution {
    public int nextGreaterElement(int n) {
        String num = n+"";
        int index1=-1;
        int index2=-1;
        int size=num.length();
        char[] nums = num.toCharArray();
        for(int i=size-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1=i;
                break;
            }
        }
        if(index1==-1){
            return -1;
        }
        // int index2=-1;
        for(int i=size-1;i>=index1;i--){
            if(nums[i]>nums[index1]){
                swap(nums,index1,i);
                index2=i;
                break;
            }
        }
        reverse(nums,index1+1,size-1);
        String s = new String(nums);
        long k=Long.parseLong(s);
        return k>Integer.MAX_VALUE?-1:(int)k;
    }
    public void reverse(char[] nums,int left,int right){
        while(left<right){
            char temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void swap(char[] nums,int left,int right){
        char temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
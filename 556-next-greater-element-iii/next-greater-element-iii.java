class Solution {
    public int nextGreaterElement(int n1) {
        String s = n1+"";
        char nums[] = s.toCharArray();
        int index1=-1,index2=-1,n=nums.length;
        for(int i=n-2;i>=0;i--) {
            if(nums[i] < nums[i+1]) {
                index1=i;
                break;
            }
        }
        if(index1==-1) {
            return -1;
            // reverse(nums,0);
        }
        else {
            for(int i=n-1;i>=index1;i--) {
                if(nums[i]>nums[index1]) {
                    index2=i;
                    break;
                }
            }
            swap(nums,index1,index2);
            reverse(nums,index1+1);
        }
        // int number = Integer.parseInt(nums.toString());
        long number = Long.parseLong(new String(nums));

        return number > Integer.MAX_VALUE?-1:(int)number;
        
    }
    public void swap(char[] nums,int index1,int index2) {
        char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public void reverse(char[] nums,int left) {
        int right=nums.length-1;
        while(left<right) {
            char temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
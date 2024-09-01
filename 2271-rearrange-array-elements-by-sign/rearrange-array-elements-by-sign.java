class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int pos=0;
        int neg=1;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result[pos]=nums[i];
                pos+=2;
            }else{
                result[neg]=nums[i];
                neg+=2;
            }
        }
        return result;
    }
}
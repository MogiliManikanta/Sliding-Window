class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int[] result = new int[n];
        if(n==0 || nums==null){
            return result;
        }
        int leftProduct = 1;
        int rightProduct = 1;
        for(int i=0;i<n;i++){
            leftProduct*=nums[i];
            result[i] = leftProduct;
        }

        for(int i=n-1;i>0;i--){
            result[i]=result[i-1]*rightProduct;
            rightProduct*=nums[i];
        }
        result[0]=rightProduct;
        return result;
    }
}
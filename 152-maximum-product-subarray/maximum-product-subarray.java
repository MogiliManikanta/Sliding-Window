class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1,suffix=1,maxProduct=Integer.MIN_VALUE,n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[n-1-i];
            maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int prefix =1,suffix=1,maximumProduct=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix = prefix*nums[i];
            suffix = suffix*nums[n-1-i];
            maximumProduct = Math.max(maximumProduct,Math.max(prefix,suffix));
        }
        return maximumProduct;
    }
}
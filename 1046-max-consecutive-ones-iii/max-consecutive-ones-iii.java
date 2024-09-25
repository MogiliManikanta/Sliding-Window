class Solution {
    public int longestOnes(int[] nums, int k) {
        // if(k==0) return 0;
        int left=0,right=0,maxi=0,zeroes=0;
        while(right<nums.length){
            if(nums[right]==0){
                zeroes++;
            }
            if(zeroes>k){
                while(left<right && zeroes>k){
                    if(nums[left]==0){
                        zeroes--;
                    }
                    left++;
                }
            }
            if(zeroes<=k){
            maxi=Math.max(maxi,right-left+1);
            }
            right++;
        }
        return maxi;
    }
}
/**class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            int zeroes=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeroes++;
                }
                if(zeroes<=k){
                    maxi=Math.max(maxi,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxi;
    }
} */
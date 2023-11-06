class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result=0;
        for(int k=2;k<n;k++){
            int i=0,j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    result+=j-i;
                    j--;
                }else{
                    i++;
                }
            }
        }
        return result;
    }
}
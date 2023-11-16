class Solution {
    public int deleteAndEarn(int[] nums123) {
        int n = 10001;
        int nums[] = new int[n];
        for(int num : nums123){
            nums[num]+=num;
        }
        //int n = nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick+=prev2;
            }
            int notpick = 0+prev1;
            int curr = Math.max(pick,notpick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
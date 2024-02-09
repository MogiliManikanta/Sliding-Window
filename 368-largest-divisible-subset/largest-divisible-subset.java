class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer>result = new ArrayList<>();
        int n=nums.length;
        if(n==0){
            return result;
        }
        int max=1;
        Arrays.sort(nums);
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    if(max<dp[i]){
                        max=dp[i];
                    }
                }
            }
        }
        int prev=-1;
        for(int i=n-1;i>=0;i--){
            if(max==dp[i] && (prev%nums[i]==0 || prev==-1)){
                result.add(nums[i]);
                max--;
                prev=nums[i];
            }
        }
        return result;
    }
}
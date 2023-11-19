class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        int maxlen = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    maxlen=Math.max(maxlen,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return  maxlen;
    }/*
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        // for(int i=0;i<=m;i++){
        //     dp[i][0]=0;
        // }
        // for(int j=0;j<=n;j++){
        //     dp[0][j]=0;
        // }
        int maxlen = 0;
        for(int i=1;i<=m;i++){
            curr[0]=0;
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    curr[j]=1+prev[j-1];
                    maxlen=Math.max(maxlen,curr[j]);
                }
                else{
                    curr[j]=0;
                }
            }
            prev = (int[])curr.clone();
        }
        return  maxlen;
    }*/
}
//samelike loongest common  substring
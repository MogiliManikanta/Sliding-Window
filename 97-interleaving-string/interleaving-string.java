class Solution {
    int[][] dp;
    char[] a,b,c;
    int aL, bL;
    public boolean isInterleave(String s1, String s2, String s3) {
        a=s1.toCharArray();
        b=s2.toCharArray();
        c=s3.toCharArray();
        aL=a.length;
        bL=b.length;
        if(aL+bL!=c.length){
            return false;
        }
        dp=new int[aL+1][bL+1];
        return dfs(0, 0);
    }
    boolean dfs(int i, int j){
        if(i+j==aL+bL){
            return true;
        }
        boolean possible=false;
        if(dp[i][j]==0){
            if(i<aL && a[i]==c[i+j]){
                possible=dfs(i+1, j);
            }
            if(!possible && j<bL && b[j]==c[i+j]){
                possible=dfs(i, j+1);
            }
            dp[i][j]=possible?1:2;
        }else{
            possible=dp[i][j]==1;   
        }
        return possible;
    }
}
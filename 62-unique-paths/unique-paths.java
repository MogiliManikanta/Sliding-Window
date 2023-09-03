/*class Solution {
    public int function(int i,int j){
        if(i==0 || j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        int up = function(i-1,j);
        int left=function(i,j-1);
        return up+left;
    }
    public int uniquePaths(int m, int n) {
        return function(m-1,n-1);
    }
}*/

/*class Solution {
    public int function(int i,int j,int[][] dp){
        if(i==0 || j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = function(i-1,j,dp);
        int left=function(i,j-1,dp);
        return dp[i][j]=up+left;
    }
    public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return function(m-1,n-1,dp);
    }
}*/
// class Solution{
//     public int uniquePaths(int m,int n){
//         int[][] dp = new int[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0 && j==0){
//                     dp[i][j]=1;
//                 }
//                 else{
//                     int up=0;
//                     int left=0;
//                     if(i>0){
//                         up=dp[i-1][j];
//                     }
//                     if(j>0){
//                         left=dp[i][j-1];
//                     }
//                     dp[i][j]=up+left;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

class Solution{
    public int uniquePaths(int m,int n){
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j]=1;
                }
                else{
                    int up=0;
                    int left=0;
                    if(i>0){
                        up=prev[j];
                    }
                    if(j>0){
                        left=curr[j-1];
                    }
                    curr[j]=up+left;
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}







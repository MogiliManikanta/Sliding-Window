/*class Solution {
    public int function(int i,int j,int[][] matrix){
        if(i>=0 && j>=0 && matrix[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        int down = function(i-1,j,matrix);
        int right = function(i,j-1,matrix);
        return down+right;
    }
    public int uniquePathsWithObstacles(int[][] Grid) {
       int m = Grid.length;
       int n = Grid[0].length;
       return function(m-1,n-1,Grid); 
    }
}*/

/*class Solution {
    public int function(int i,int j,int[][] matrix,int[][] dp){
        if(i>=0 && j>=0 && matrix[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = function(i-1,j,matrix,dp);
        int right = function(i,j-1,matrix,dp);
        return dp[i][j] = down+right;
    }
    public int uniquePathsWithObstacles(int[][] Grid) {
       int m = Grid.length;
       int n = Grid[0].length;
       int[][] dp = new int[m][n];
       for(int[] arr : dp){
           Arrays.fill(arr,-1);
       }
       return function(m-1,n-1,Grid,dp); 
    }
}*/
/*class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;
       int[][] dp = new int[m][n];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(matrix[i][j]==1){
                   dp[i][j]=0;
               }
               else if(i==0 && j==0){
                   dp[i][j]=1;
               }
               else{
                   int up=0;
                   int left=0;
                   if(i>0){
                       up = dp[i-1][j];
                   }
                   if(j>0){
                       left=dp[i][j-1];
                   }
                   dp[i][j]=up+left;
               }
           }
       }
       return dp[m-1][n-1]; 
    }
}*/


class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;
       int[] prev = new int[n];
       for(int i=0;i<m;i++){
           int[] curr = new int[n];
           for(int j=0;j<n;j++){
               if(matrix[i][j]==1){
                   curr[j]=0;
               }
               else if(i==0 && j==0){
                   curr[j]=1;
               }
               else{
                   int up=0;
                   int left=0;
                   if(i>0){
                       up = prev[j];
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
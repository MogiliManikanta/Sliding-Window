/*class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){ //filling first column
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<n;j++){//filling first row
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}*/
/*class Solution {
    public int function(int i,int j,int[][] grid){
        if(i< 0 || j<0){
            return (int)Math.pow(10,9)+7;
        }
        if(i==0 && j==0){
            return grid[i][j];
        }
        int up = grid[i][j]+function(i-1,j,grid);
        int left = grid[i][j]+function(i,j-1,grid);
        return Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return function(m-1,n-1,grid);
    }
}*/
/*class Solution {
    public int function(int i,int j,int[][] grid ,int[][] dp){
        if(i< 0 || j<0){
            return (int)Math.pow(10,9)+7;
        }
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = grid[i][j]+function(i-1,j,grid,dp);
        int left = grid[i][j]+function(i,j-1,grid,dp);
        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return function(m-1,n-1,grid,dp);
    }
}*/

/*class Solution{
    public int minPathSum(int[][] grid){
       int m = grid.length;
       int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[0][0];
                }
                else{
                    int up=0;
                    if(i>0){
                        up+=grid[i][j]+dp[i-1][j];
                    }
                    else{
                        up = (int)Math.pow(10,9)+7;
                    }
                    int left=0;
                    if(j>0){
                        left+=grid[i][j]+dp[i][j-1];
                    }
                    else{
                        left+=Math.pow(10,9)+7;
                    }
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1]; 
    }
}*/
class Solution{
    public int minPathSum(int[][] grid){
       int m = grid.length;
       int n = grid[0].length;
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j]=grid[0][0];
                }
                else{
                    int up=0;
                    if(i>0){
                        up+=grid[i][j]+prev[j];
                    }
                    else{
                        up = (int)Math.pow(10,9)+7;
                    }
                    int left=0;
                    if(j>0){
                        left+=grid[i][j]+curr[j-1];
                    }
                    else{
                        left+=Math.pow(10,9)+7;
                    }
                    curr[j]=Math.min(up,left);
                }
            }
            prev=curr;
        }
        return prev[n-1]; 
    }
}

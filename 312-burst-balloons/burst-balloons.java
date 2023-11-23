class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j){
                    continue;
                }
                int coins=Integer.MIN_VALUE;
                for(int index=i;index<=j;index++){
                    int temp = arr[i-1]*arr[index]*arr[j+1]+dp[i][index-1]+dp[index+1][j];
                    coins=Math.max(coins,temp);
                }
                dp[i][j]=coins;
            }
        }
        return dp[1][n];
    }
}
class Solution123 {
    private int f(int i,int j,int[] temp,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for(int ind =i;ind<=j;ind++){
            int cost = temp[i-1]*temp[ind]*temp[j+1]+f(i,ind-1,temp,dp)+f(ind+1,j,temp,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
       int[] temp = new int[n+2];
       temp[0]=1;
       temp[n+1]=1;
       for(int i=0;i<n;i++){
           temp[i+1]=nums[i];
       }
       int[][] dp = new int[n+2][n+2];
       for(int i=n;i>=1;i--){
           for(int j=1;j<=n;j++){
               if(i>j){
                   continue;
               }
            int maxi = Integer.MIN_VALUE;
            for(int ind =i;ind<=j;ind++){
                int cost = temp[i-1]*temp[ind]*temp[j+1]+dp[i][ind-1]+dp[ind+1][j];
            maxi = Math.max(maxi,cost);
        }
        dp[i][j] = maxi;
           }
       }
       return dp[1][n];
    }
}
/**The code given by the user is in C++ language and it is a solution for the problem of finding the maximum coins that can be obtained by bursting balloons. The code uses a recursive function f that takes the indices of the left and right boundaries of the balloons and a reference to the vector of balloon values. The function returns the maximum coins that can be obtained by bursting all the balloons between the boundaries. The function iterates over all the possible choices of the last balloon to burst and calculates the cost of that choice by multiplying the values of the left, right and last balloons and adding the recursive calls for the left and right subproblems. The function returns the maximum cost among all the choices. The main function maxCoins takes a vector of balloon values and adds 1 to both ends of the vector to represent the walls. It then calls the recursive function with 1 and n as the boundaries, where n is the original size of the vector. */
/*public class Solution {
    public int f(int i, int j, int[] a) {
        if (i > j) return 0;
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a[i - 1] * a[ind] * a[j + 1] +
                       f(i, ind - 1, a) + f(ind + 1, j, a);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }

    public int maxCoins(int[] a) {
        int n = a.length;
        int[] b = new int[n + 2];
        b[0] = 1;
        b[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            b[i + 1] = a[i];
        }
        return f(1, n, b);
    }
}*/

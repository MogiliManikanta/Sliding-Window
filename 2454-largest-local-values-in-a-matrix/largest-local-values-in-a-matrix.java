class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int[][] ans = new int[n-2][n-2];
        
        // Brute force
				// [i][j] represent top left corner
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                int max = -1;
                // run 3 rows and 3 columns
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        max = Math.max(max, grid[i+k][j+l]);
                    }
                }
                ans[i][j]=max;
            }
        }
        return ans;
    }
}
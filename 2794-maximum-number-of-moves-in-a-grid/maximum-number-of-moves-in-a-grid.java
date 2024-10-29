class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxValues[][] = new int[m][n];
        for(int col=n-2;col>-1;col--){
            for(int row=0;row<m;row++){
                int currentValue = grid[row][col];
                if(row-1>=0  && grid[row-1][col+1]>currentValue){
                    maxValues[row][col] = Math.max(maxValues[row][col],maxValues[row-1][col+1]+1);
                }
                if(grid[row][col+1]>currentValue){
                    maxValues[row][col] = Math.max(maxValues[row][col],maxValues[row][col+1]+1); 
                }
                if(row+1<m  && grid[row+1][col+1]>currentValue){
                    maxValues[row][col] = Math.max(maxValues[row][col],maxValues[row+1][col+1]+1);
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            ans=Math.max(ans,maxValues[i][0]);
        }
        return ans;
    }
}
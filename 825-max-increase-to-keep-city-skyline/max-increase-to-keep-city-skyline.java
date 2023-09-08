class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] row = new int[rowLength];
        int[] col = new int[colLength];
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                row[i] = Math.max(row[i],grid[i][j]);
                col[j] = Math.max(col[j],grid[i][j]);
            }
        }
        int ans=0;
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                ans+=Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return ans;
    }
}
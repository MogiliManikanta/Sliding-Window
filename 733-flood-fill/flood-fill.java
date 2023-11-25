class Solution {
    private void dfs(int[][] result,int[][] image,int initialColor,int newColor,int[] deltaRow,int[] deltaCol,int sr,int sc,int n,int m){
        result[sr][sc]=newColor;
        for(int i=0;i<4;i++){
            int nrow = deltaRow[i]+sr;
            int ncol = deltaCol[i]+sc;
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol]==initialColor && result[nrow][ncol]!=newColor){
                dfs(result,image,initialColor,newColor,deltaRow,deltaCol,nrow,ncol,n,m);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialColor = image[sr][sc];

        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1};

        int result[][] = image;

        dfs(result,image,initialColor,color,deltaRow,deltaCol,sr,sc,n,m);
        return result;
    }
}
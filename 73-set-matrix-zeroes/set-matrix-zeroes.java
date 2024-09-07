class Solution {
    public void setZeroes(int[][] matrix) {
        int col0=1,row=matrix.length,col=matrix[0].length;
        // int col[m] = matrix[...][0]
        // int row[n] = matrix[0][...]
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    // mark the row 
                    matrix[i][0]=0;
                    // mark the col
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        // For the column
        if(matrix[0][0]==0){
            for(int i=0;i<col;i++){
                matrix[0][i]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }
}
/*class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowAns = new int[row];
        int[] colAns = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowAns[i]=-1;
                    colAns[j]=-1;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowAns[i]==-1 || colAns[j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}*/
/*****class Solution {
    public void setZeroes(int[][] matrix) {
        int col=matrix[0].length;
        int row=matrix.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i);
                    markCol(matrix,j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
        // return matrix;
    }
    public void markRow(int[][] matrix,int row){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[row][i]!=0)
                matrix[row][i]=-1;
        }
    }
    public void markCol(int[][] matrix,int col){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]!=0)
                matrix[i][col]=-1;
        }
    }
} */
class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        int col0=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    //mark the row
                    matrix[i][0]=0;
                    if(j!=0){
                        // mark column
                        matrix[0][j]=0;
                    }
                    else{
                        col0=1;
                    }
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(matrix[0][0]==0){
            for(int i=0;i<column;i++){
                matrix[0][i]=0;
            }
        }
        if(col0==1){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }
}
/**class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        int[] rowMark = new int[row];
        int[] columnMark = new int[column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    rowMark[i]=-1;
                    columnMark[j]=-1;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(rowMark[i]==-1 || columnMark[j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
/**class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,i);
                    markColumn(matrix,j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public void markRow(int[][] matrix,int row){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[row][i]!=0){
            matrix[row][i]=-1;
            }
        }
    }
    public void markColumn(int[][] matrix,int column){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][column]!=0){
            matrix[i][column]=-1;}
        }
    }
} */ 
class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        // step 1 : Transpose the matrix
        for(int i=0;i<row;i++){
            for(int j=i+1;j<column;j++){
                // swap the matrix[i][j] to matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        // 1 2 3        1 4 7        7 4 1
        // 4 5 6    ==> 2 5 8   ==>  8 5 2
        // 7 8 9        3 6 9        9 6 3

        for(int i=0;i<row;i++){
            for(int j=0;j<column/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][column-1-j];
                matrix[i][column-1-j]=temp;
            }
        }
    }
}
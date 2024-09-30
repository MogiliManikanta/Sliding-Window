class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length,column=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i+1;j<column;j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column/2;j++) {
                int temp=matrix[i][j];
                matrix[i][j] = matrix[i][column-1-j];
                matrix[i][column-1-j]=temp;
            }
        }
    }
}

//

// 1 4 7
// 2 5 8
// 3 6 9

class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i;j<column;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][column-1-j];  // in place algorithm
                matrix[i][column-1-j]=temp;
            }
        }
    }
}
/**done once see it
1.step1 transpose
2.reverse using in place algorithm

/** step1 : transpose
1 4 7
2 5 8
3 6 9


step 2 : in-place algorithm

7 4 1 
8 5 2
9 6 3

*/
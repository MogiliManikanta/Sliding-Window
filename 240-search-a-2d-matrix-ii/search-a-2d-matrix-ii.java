class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0;
        int column=matrix[0].length-1;
        while(row<n && column>=0){
            if(matrix[row][column]==target){
                return true;
            }
            else if(matrix[row][column]<target){
                row++;
            }
            else{
                column--;
            }
        }
        return false;
    }
}
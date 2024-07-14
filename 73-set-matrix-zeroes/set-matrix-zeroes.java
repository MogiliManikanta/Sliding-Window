class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstColumn = false; // Flag to check if the first column should be set to zero
        boolean firstRow = false; // Flag to check if the first row should be set to zero
        
        // Check if the first row contains any zeros
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        
        // Check if the first column contains any zeros
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }
        
        // Use the first row and first column to mark zeros
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the corresponding cell in the first column
                    matrix[0][j] = 0; // Mark the corresponding cell in the first row
                }
            }
        }
        
        // Set the elements to zero based on the marks in the first row and first column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Set the first row to zero if needed
        for (int i = 0; i < matrix[0].length; i++) {
            if (firstRow) {
                matrix[0][i] = 0;
            }
        }
        
        // Set the first column to zero if needed
        for (int i = 0; i < matrix.length; i++) {
            if (firstColumn) {
                matrix[i][0] = 0;
            }
        }
    }
}

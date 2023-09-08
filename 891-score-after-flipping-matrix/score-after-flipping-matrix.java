class Solution {
    public int matrixScore(int[][] A) {
    int M = A.length;  // Number of rows
    int N = A[0].length;  // Number of columns
    int score = 0;  // Initialize the score

    // First, maximize the leftmost column values
    for (int i = 0; i < M; i++) {
        if (A[i][0] == 0) {
            flipRow(A, i);  // Flip the row if the leftmost element is 0
        }
    }

    // Calculate the score by iterating through columns
    for (int j = 0; j < N; j++) {
        int ones = 0;  // Count of 1s in the current column

        for (int i = 0; i < M; i++) {
            ones += A[i][j];
        }

        // Choose the maximum count of 1s or 0s to maximize the score
        int maxOnes = Math.max(ones, M - ones);
        score += maxOnes * (1 << (N - j - 1));  // Update the score
    }

    return score;
}

// Helper function to flip a row by changing 0s to 1s and vice versa
private void flipRow(int[][] A, int row) {
    for (int j = 0; j < A[row].length; j++) {
        A[row][j] = 1 - A[row][j];
    }
}

}
class Solution {
    public int maxFrequency(int[] A, int k) {
        // sort(begin(A), end(A));
        Arrays.sort(A);
        int  i = 0, j = 0, N = A.length, sum = 0;
        for (; j < N; ++j) {
            sum += A[j];
            if ((j - i + 1) * A[j] - sum > k) sum -= A[i++];
        }
        return j - i;
    }
}
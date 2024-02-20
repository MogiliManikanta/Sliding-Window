class Solution {
    public int longestOnes(int[] A, int K) {
        int start = 0, max = Integer.MIN_VALUE, zeroCounter = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) {
                zeroCounter++;
            }
            while (zeroCounter > K) {
                if (A[start] == 0) {
                    zeroCounter--;
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
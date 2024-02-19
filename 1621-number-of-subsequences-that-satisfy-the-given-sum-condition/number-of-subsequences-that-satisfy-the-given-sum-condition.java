class Solution {
      public int numSubseq(int[] A, int target) {
        Arrays.sort(A);
        int res = 0, n = A.length, left = 0, right = n - 1, mod = (int)1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1,index=0 ; i < n ; ++i){
            pows[i] = pows[i - 1] * 2 % mod;
            System.out.print(pows[index++]+" ");
        }
        while (left <= right) {
            if (A[left] + A[right] > target) {
                right--;
            } else {
                res = (res + pows[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}
/***

We don't care the original elements order,
we only want to know the count of sub sequence.
So we can sort the original A, and the result won't change.

 */
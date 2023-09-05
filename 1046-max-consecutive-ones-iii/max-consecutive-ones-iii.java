class Solution {
    public int longestOnes(int[] A, int K) {
    int left = 0;
    int right = 0;
    int max = 0;
    
    int numZeroes = 0;
    for (right= 0; right<A.length; right++) {

        if (A[right]==0) numZeroes++;
        
        if (numZeroes > K) {
            if (A[left]==0) numZeroes--;
            left ++;
        }
        if (numZeroes <= K) {
            // this is probably what I could come up during interview...
            max = Math.max(max, right-left +1 );
        }
    }
    return max;
}
}
/**For each A[j], try to find the longest subarray.
If A[i] ~ A[j] has zeros <= K, we continue to increment j.
If A[i] ~ A[j] has zeros > K, we increment i (as well as j). */
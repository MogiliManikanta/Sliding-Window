class Solution {
    public int longestOnes(int[] A, int K) {
        int[] freq = new int[2];
        int i = 0, r=0;
        for(int j = 0; j < A.length; j++){
            freq[A[j]] ++;
            while(freq[0] > K && i <= j){
                freq[A[i]] --;
                i++;
            }
            r = Math.max(r, j-i+1);
        }
        return r;
    }
}
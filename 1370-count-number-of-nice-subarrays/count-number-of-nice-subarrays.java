class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
}

public int atMost(int[] A, int k) {
    int res = 0;
    int i = 0;
    int n = A.length;
    int[] freq = new int[2];
    
    for (int j = 0; j < n; j++) {
        freq[A[j] % 2]++;
        
        while (freq[1] > k) {
            freq[A[i] % 2]--;
            i++;
        }
        
        res += j - i + 1;
    }
    
    return res;
}

}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        
        int[] cummulativeSumFromFront = new int[n+1];
        int[] cummulativeSumFromBehind = new int[n+1];
        
        sum = 0;
        for (int i=0; i<n; i++) {
            sum += cardPoints[i];
            cummulativeSumFromFront[i+1] = sum;
        }
        sum = 0;
        for (int i=n-1; i>=0; i--) {
            sum += cardPoints[i];
            cummulativeSumFromBehind[i] = sum;
        }
        
        // Reversing is optional. I reversed it so that it would be easy
        // to access sum of last (k-i) elements by just indexing at [k-i]
        // Otherwise, I would have had to index it at [n-k+i] which would
        // have made it difficult to read.
        reverse(cummulativeSumFromBehind);
        
        int answer = 0;
        for(int i=0; i<=k; i++) {      
            answer = Math.max(answer, 
                           cummulativeSumFromFront[i] // Sum of first 'i' cards.
                         + cummulativeSumFromBehind[k-i]); // Sum of last 'k-i' cards.
        }
        return answer;
    }
    
    // Helper method to reverse an array
    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

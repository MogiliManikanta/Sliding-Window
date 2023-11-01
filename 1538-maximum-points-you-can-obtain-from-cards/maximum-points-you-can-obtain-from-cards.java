class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // The problem is to find the maximum score you can obtain by choosing k cards from either end of the array
        // The idea is to use two arrays to store the cumulative sum of the cards from the front and from the behind
        // Then, for each possible number of cards chosen from the front (i), we can find the corresponding number of cards chosen from the behind (k-i)
        // We can then add the cumulative sum of the front and the behind for each pair of i and k-i, and find the maximum among them
        
        int sum = 0; // This variable will store the temporary sum of the cards
        int n = cardPoints.length; // This variable will store the length of the cardPoints array
        
        int[] cummulativeSumFromFront = new int[n+1]; // This array will store the cumulative sum of the cards from the front
        int[] cummulativeSumFromBehind = new int[n+1]; // This array will store the cumulative sum of the cards from the behind
        
        sum = 0; // Initialize the sum to zero
        for (int i=0; i<n; i++) { // Loop through all the cards from the front
            sum += cardPoints[i]; // Add the current card to the sum
            cummulativeSumFromFront[i+1] = sum; // Store the sum in the array at index i+1
        }
        sum = 0; // Initialize the sum to zero
        for (int i=n-1; i>=0; i--) { // Loop through all the cards from the behind
            sum += cardPoints[i]; // Add the current card to the sum
            cummulativeSumFromBehind[i] = sum; // Store the sum in the array at index i
        }
        
        // Reversing is optional. I reversed it so that it would be easy
        // to access sum of last (k-i) elements by just indexing at [k-i]
        // Otherwise, I would have had to index it at [n-k+i] which would
        // have made it difficult to read.
        reverse(cummulativeSumFromBehind); // Reverse the array that stores the cumulative sum from the behind
        
        int answer = 0; // This variable will store the final answer
        for(int i=0; i<=k; i++) {      // Loop through all possible values of i from 0 to k
            answer = Math.max(answer,  // Update the answer by taking the maximum of 
                           cummulativeSumFromFront[i] // Sum of first 'i' cards.
                         + cummulativeSumFromBehind[k-i]); // Sum of last 'k-i' cards.
        }
        return answer; // Return the final answer
    }
    
    // Helper method to reverse an array
    public void reverse(int[] arr) {
        int left = 0; // This variable will store the left pointer
        int right = arr.length - 1; // This variable will store the right pointer
        while (left < right) { // Loop until left and right pointers cross each other
            int temp = arr[left]; // Store the value at left pointer in a temporary variable
            arr[left] = arr[right]; // Swap the value at left pointer with the value at right pointer
            arr[right] = temp; // Swap the value at right pointer with the value in temporary variable
            left++; // Increment left pointer by one
            right--; // Decrement right pointer by one
        }
    }
}

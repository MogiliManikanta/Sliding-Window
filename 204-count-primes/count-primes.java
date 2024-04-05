import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        // Initialize an ArrayList to store prime numbers
        ArrayList<Integer> al = new ArrayList<>();
        
        // Convert n to long
        long N = (long)n;
        
        // Initialize an array to mark prime numbers
        boolean isPrime[] = new boolean[(int)(N + 1)];

        // Arrays.fill(isPrime, true) initializes the array with true values
        Arrays.fill(isPrime, true);

        // Iterate from 2 to (N-1)
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {
                // If i is prime, add it to the list
                al.add(i);
            }
            // Mark multiples of i as non-prime
            for (long j = (long)i * i; j <= N; j += i) {
                isPrime[(int)j] = false;
            }
        }
        
        // Return the size of the list, which is the count of prime numbers
        return al.size();
    }
}

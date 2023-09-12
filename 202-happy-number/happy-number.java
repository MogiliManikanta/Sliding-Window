class Solution {
    public boolean isHappy(int n) {
        // Create a HashSet to store the calculated values to check for cycles
        HashSet<Integer> set = new HashSet<>();
        
        // Use a while loop to iterate until a cycle is detected or we find a happy number
        while (set.add(n)) { // If 'n' is already in the set, it means we've entered a cycle.
            
            // Initialize a variable to store the sum of squares of digits
            int squareSum = 0;
            
            // Calculate the sum of squares of each digit in 'n'
            while (n != 0) {
                int temp = n % 10;          // Extract the last digit of 'n'
                squareSum += (temp * temp); // Square the digit and add it to 'squareSum'
                n /= 10;                    // Remove the last digit from 'n'
            }
            
            // Check if 'squareSum' is equal to 1, indicating that 'n' is a happy number
            if (squareSum == 1) {
                return true;
            } else {
                // If 'squareSum' is not 1, update 'n' with the new value 'squareSum'
                n = squareSum;
            }
        }
        
        // If we reach here, it means we've entered a cycle and couldn't find a happy number
        return false;
    }
}
/**The idea is to use one hash set to record sum of every digit square of every number occurred. Once the current sum cannot be added to set, return false; once the current sum equals 1, return true; */
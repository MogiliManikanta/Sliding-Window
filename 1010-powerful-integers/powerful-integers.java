import java.util.*;
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        // Set to store the resulting powerful integers (to avoid duplicates)
        Set<Integer> result = new HashSet<>();
        
        // Loop through all possible powers of x starting from 1
        for (int a = 1; a < bound; a *= x) {
            // Loop through all possible powers of y starting from 1
            for (int b = 1; a + b <= bound; b *= y) {
                // Add the sum of powers of x and y to the result set
                result.add(a + b);
                
                // If y is 1, break the loop since further multiplication won't change the result
                if (y == 1) {
                    break;
                }
            }
            
            // If x is 1, break the loop since further multiplication won't change the result
            if (x == 1) {
                break;
            }
        }
        
        // Convert the set to list and return the result
        return new ArrayList<>(result);
    }
}

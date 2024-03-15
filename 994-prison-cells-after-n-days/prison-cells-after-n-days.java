import java.util.*;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        // Map to store the seen states of cells along with the day they occurred
        Map<String, Integer> seen = new HashMap<>();
        
        // Iterate while N is greater than 0
        while (N > 0) {
            // Create a new array to store the state of cells for the next day
            int[] cells2 = new int[8];
            
            // Store the current state of cells as a string representation in the map along with the current day
            seen.put(Arrays.toString(cells), N--);
            
            // Update the state of cells according to the rules provided
            for (int i = 1; i < 7; ++i) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            
            // Update cells to the state of cells for the next day
            cells = cells2;
            
            // Check if the current state of cells is already seen
            if (seen.containsKey(Arrays.toString(cells))) {
                // Adjust N to skip iterations and directly reach the day when the cycle starts repeating
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        
        // Return the final state of cells after N days
        return cells;
    }
}

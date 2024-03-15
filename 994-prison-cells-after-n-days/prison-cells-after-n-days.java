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
/*let's say N = 1000, we know after every 14 days, same prison state will come....
so, if I do N%14 = 6 (which means until the last 6th day, my states will repeat....)
so there is no point in doing repeated changing states, rather just jump to the last 6th.
now, 6%14 or 5%15 or 4%14 .... are just 6, 5, 4 .... which means you only need to worry about the last few days, which is a good performance*/


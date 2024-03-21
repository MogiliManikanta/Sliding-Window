import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] diff, int[] profit, int[] workers) {
        // Combine difficulties and profits into a 2D array
        int[][] tasks = new int[diff.length][2];
        for (int i = 0; i < diff.length; i++) {
            tasks[i][0] = diff[i]; // Difficulty
            tasks[i][1] = profit[i]; // Profit
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0])); // Sort tasks by difficulty

        int totalProfit = 0;
        Arrays.sort(workers); // Sort worker abilities

        int maxProfit = 0;
        int taskIdx = 0;

        // Iterate over each worker's ability
        for (int ability : workers) {
            // Check tasks that worker can handle
            while (taskIdx < tasks.length && ability >= tasks[taskIdx][0]) {
                // Update max profit if current task's profit is greater
                maxProfit = Math.max(maxProfit, tasks[taskIdx][1]);
                taskIdx++; // Move to next task
            }

            totalProfit += maxProfit; // Add best profit to total profit
        }

        return totalProfit;
    }
}

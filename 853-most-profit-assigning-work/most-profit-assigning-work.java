import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxProfitAssignment(int[] diff, int[] profit, int[] worker) {

        // Creating a 2D array to store difficulty-profit pairs
        int pair[][] = new int[diff.length][2];

        // Iterating through each element in the 'diff' array
        for(int i = 0; i < diff.length; i++){
            // Storing the difficulty and profit corresponding to each index 'i' in the 'pair' 2D array
            pair[i][0] = diff[i];    // Assigning difficulty
            pair[i][1] = profit[i];  // Assigning profit
        }

        // Sorting the 2D array based on the difficulty column
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]){
                // Comparing the difficulty values at index 0 of each pair
                // and returning the result of the comparison
                return Integer.valueOf(o1[0]).compareTo(o2[0]);
            }
        });

        int totalProfit = 0;
        Arrays.sort(worker); // Sort worker abilities

        int bestProfitSoFar = 0;
        int taskIndex = 0;

        // Iterate over each worker
        for (int workerAbility : worker) {
            // Check tasks that worker can handle
            while (taskIndex < pair.length && workerAbility >= pair[taskIndex][0]) {
                // Update best profit if current task's profit is greater
                bestProfitSoFar = Math.max(bestProfitSoFar, pair[taskIndex][1]);
                taskIndex++; // Move to next task
            }

            totalProfit += bestProfitSoFar; // Add best profit to total profit
        }

        return totalProfit;
    }
}

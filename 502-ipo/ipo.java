public class Solution {
    public int findMaximizedCapital(int k, int W, int[] p, int[] c) {
        int n = p.length;
        List<int[]> projects = new ArrayList<>();

        // Create a list of pairs (profit, capital) from the given arrays
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{p[i], c[i]});
        }

        // Sort the projects by capital in ascending order
        Collections.sort(projects, (a, b) -> Integer.compare(a[1], b[1]));

        // Create a max heap (priority queue) to store project profits
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;

        // Iterate while there are projects to select (k > 0)
        while (k > 0) {
            // Iterate through projects with capital requirements less than or equal to available capital (W)
            while (i < n && projects.get(i)[1] <= W) {
                // Add project profits to the max heap
                pq.offer(projects.get(i)[0]);
                i++;
            }

            // If the max heap is not empty (i.e., there are projects to select)
            if (!pq.isEmpty()) {
                // Select the project with the highest profit (top of the max heap)
                int maxProfit = pq.poll();
                // Increase the available capital by the selected project's profit
                W += maxProfit;
            }

            // Decrement k to keep track of the number of projects selected
            k--;
        }

        // Return the available capital after selecting the desired number of projects
        return W;
    }
}

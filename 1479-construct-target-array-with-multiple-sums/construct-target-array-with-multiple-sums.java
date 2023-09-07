public class Solution {
    public boolean isPossible(int[] target) {
        int tsum = 0; // Total sum of elements in the 'target' array
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder()); // Max heap (priority queue)

        // Calculate the total sum of elements in the 'target' array and add elements to the max heap
        for (int x : target) {
            tsum += x;
            maxq.offer(x);
        }

        // Continue the loop until the largest element in the max heap becomes 1
        while (maxq.peek() != 1) {
            int large = maxq.poll(); // Remove and get the largest element from the max heap
            tsum = tsum - large; // Subtract the value of 'large' from the total sum

            // Check if 'tsum' is less than or equal to 0 or greater than or equal to 'large'
            // If either condition is met, it's impossible to reach the target, so return false
            if (tsum <= 0 || tsum >= large) {
                return false;
            }

            // Calculate the new 'large' value as the remainder of 'large' divided by 'tsum'
            // If 'large' is not divisible by 'tsum', 'large' will be set to the remainder
            large = large % tsum;

            // If 'large' is not 0, add it back to the max heap; otherwise, add 'tsum' to the max heap
            maxq.offer(large != 0 ? large :  tsum);

            // Add 'large' (or 'tsum') back to 'tsum' to maintain the correct total sum
            tsum = tsum + large;
        }

        // If the loop exits, and the largest element in the max heap is 1, it's possible to reach the target, so return true
        return true;
    }
}
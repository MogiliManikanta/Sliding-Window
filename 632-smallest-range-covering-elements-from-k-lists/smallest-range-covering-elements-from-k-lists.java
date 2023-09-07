import java.util.*;

public class Solution {
    class Node {
        int data, row, col;

        Node(int data, int row, int col) {
            this.data = data;
            this.col = col;
            this.row = row;
        }
    }

    class Compare implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.data - b.data;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Compare());

        int n = nums.size();

        // Finding min and max for the first column
        for (int i = 0; i < n; i++) {
            int ele = nums.get(i).get(0);
            mini = Math.min(mini, ele);
            maxi = Math.max(maxi, ele);
            minHeap.offer(new Node(ele, i, 0));
        }

        // Initial range
        int start = mini, end = maxi;

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();

            if (curr.col + 1 < nums.get(curr.row).size()) {
                int r = curr.row;
                int c = curr.col + 1;
                minHeap.offer(new Node(nums.get(r).get(c), r, c));

                mini = minHeap.peek().data;
                maxi = Math.max(maxi, nums.get(r).get(c));

                if (maxi - mini < end - start) {
                    start = mini;
                    end = maxi;
                }
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }
}

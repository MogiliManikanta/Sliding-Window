/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();  // List to store the result
        Queue<TreeNode> queue = new LinkedList<>();      // Queue for level-order traversal

        if (root == null) {
            return result;  // If the root is null, return an empty result
        }

        queue.offer(root);  // Add the root node to the queue

        while (!queue.isEmpty()) {
            int size = queue.size();  // Get the number of nodes at the current level
            List<Integer> levelValues = new ArrayList<>();  // List to store values at the current level

            // Process all nodes at the current level
            while (size > 0) {
                TreeNode current = queue.poll();  // Remove the first node from the queue
                levelValues.add(current.val);     // Add its value to the current level list

                // Add the left and right children of the current node to the queue (if they exist)
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

                size--;  // Decrement the size to track processed nodes
            }

            result.add(levelValues);  // Add the list of values at the current level to the result
        }

        return result;  // Return the final result containing level-wise node values
    }
}
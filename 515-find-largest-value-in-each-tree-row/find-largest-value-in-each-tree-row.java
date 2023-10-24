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
    public List<Integer> largestValues(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<TreeNode>(); // Create a queue for level-order traversal
    List<Integer> values = new ArrayList<Integer>(); // Create a list to store the largest values
    
    if (root != null) {
        q.offer(root); // Add the root node to the queue if it's not null
    }
    
    while (!q.isEmpty()) {
        int max = Integer.MIN_VALUE; // Initialize the maximum value to the smallest integer value
        int n = q.size(); // Get the number of nodes at the current level
        
        for (int i = 0; i < n; i++) {
            TreeNode node = q.poll(); // Dequeue a node from the front of the queue
            max = Math.max(max, node.val); // Update the maximum value if the current node's value is greater
            
            if (node.left != null) {
                q.offer(node.left); // Add the left child to the queue if it's not null
            }
            
            if (node.right != null) {
                q.offer(node.right); // Add the right child to the queue if it's not null
            }
        }
        
        values.add(max); // Add the maximum value of the current level to the 'values' list
    }
    
    return values; // Return the list of largest values in each level
}
}
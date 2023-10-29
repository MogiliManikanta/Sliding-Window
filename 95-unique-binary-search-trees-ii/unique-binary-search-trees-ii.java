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
    // Public method to generate all possible unique binary search trees
    public List<TreeNode> generateTrees(int n) {
        // Start the recursive construction from the range 1 to n
        return helper(1, n);
    }

    // Helper method to generate unique binary search trees within a given range
    List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        
        // If the start exceeds the end, there are no valid trees in this range
        if (start > end) {
            list.add(null); // Add a null node to represent an empty tree
            return list;
        }

        // If start and end are the same, there is only one possible tree
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        // Iterate through each number in the range
        for (int i = start; i <= end; i++) {
            // Recursively generate left and right subtrees
            List<TreeNode> leftPossibleTrees = helper(start, i - 1);
            List<TreeNode> rightPossibleTrees = helper(i + 1, end);

            // Connect the root node with left and right subtrees
            for (TreeNode lRoot : leftPossibleTrees) {
                for (TreeNode rRoot : rightPossibleTrees) {
                    TreeNode root = new TreeNode(i); // Create the current root node
                    root.left = lRoot; // Set the left subtree
                    root.right = rRoot; // Set the right subtree
                    list.add(root); // Add this tree to the list of possibilities
                }
            }
        }
        return list; // Return the list of all possible trees in the given range
    }
}
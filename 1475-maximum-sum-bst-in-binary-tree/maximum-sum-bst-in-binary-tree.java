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
    private int maxSum = 0; // Initialize a variable to keep track of the maximum sum found.

    public int maxSumBST(TreeNode root) {
        postOrderTraverse(root); // Start the post-order traversal from the root of the tree.
        return maxSum; // Return the maximum sum found in a BST.
    }

    private int[] postOrderTraverse(TreeNode root) {
        if (root == null) {
            // Base case: Return an array representing an empty subtree.
            // The array contains minimum value, maximum value, and sum (initialized to 0).
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        // Recursively traverse the left and right subtrees.
        int[] left = postOrderTraverse(root.left);
        int[] right = postOrderTraverse(root.right);

        // Check if the current subtree is a valid BST.
        if (!(left != null && right != null && root.val > left[1] && root.val < right[0])) {
            return null; // If not, return null to indicate it's not a valid BST.
        }

        // Calculate the sum of the current subtree (including the root).
        int sum = root.val + left[2] + right[2];

        // Update the maximum sum if the current subtree's sum is greater.
        maxSum = Math.max(maxSum, sum);

        // Calculate the minimum and maximum values of the current subtree.
        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);

        // Return an array containing the minimum value, maximum value, and sum of the current subtree.
        return new int[]{min, max, sum};
    }
}
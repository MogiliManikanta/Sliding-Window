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
/*public class Solution {
    public int minCameraCover(TreeNode root) {
        int sum = 0;
        if (dfs(root, sum) == 0) sum++; // if root is not monitored, we place an additional camera here
        return sum;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) return 1; // base case
        int left = dfs(node.left, sum);
        int right = dfs(node.right, sum);
        if (left == 0 || right == 0) { // if at least 1 child is not monitored, we need to place a camera at the current node
            sum++;
            return 2;
        } else if (left == 2 || right == 2) { // if at least 1 child has a camera, the current node is monitored. Thus, we don't need to place a camera here
            return 1;
        } else { // if both children are monitored but have no camera, we don't need to place a camera here. We place the camera at its parent node at the higher level.
            return 0;
        }
    }
}*/


public class Solution {
    int result = 0; // Initialize a variable 'result' to keep track of the number of cameras placed.

    public int minCameraCover(TreeNode root) {
        // Start the depth-first search (dfs) from the root of the tree and return the minimum number of cameras needed.
        // If the result of dfs is less than 1, it means the root node is not monitored, so we place an additional camera at the root.
        return (dfs(root) < 1 ? 1 : 0) + result;
    }

    public int dfs(TreeNode node) {
        // This function performs a depth-first search (dfs) on the tree.
        if (node == null) return 2; // If the current node is null, it is considered as monitored, so return 2.

        // Recursively call dfs on the left and right subtrees to get their results.
        int leftResult = dfs(node.left);
        int rightResult = dfs(node.right);

        // If at least one of the child nodes needs a camera (has a result of 0), we need to place a camera at the current node.
        if (leftResult == 0 || rightResult == 0) {
            result++; // Increment the camera count.
            return 1;  // Return 1 to indicate that the current node is now monitored.
        }

        // If both child nodes are monitored (have a result of 1), or if at least one of them has a camera (has a result of 2),
        // it means the current node is monitored without needing a camera.
        return (leftResult == 1 || rightResult == 1) ? 2 : 0; // Return 2 if monitored, 0 if not.
    }
}

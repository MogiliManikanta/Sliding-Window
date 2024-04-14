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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        return sum;
    }
}

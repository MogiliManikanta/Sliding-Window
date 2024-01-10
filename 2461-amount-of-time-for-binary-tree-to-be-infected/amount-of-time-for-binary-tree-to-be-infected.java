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
    
    private int amount;
    
    public int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return amount;
    }
    
    // if subtree does not contain infected node, return maximum depth
    // if subtree contains infected node, return infected node depth (use negative value to distinguish this case)
    private int traverse(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        
        int left = traverse(root.left, start);
        int right = traverse(root.right, start);
        
        if (root.val == start) {
            // we are at the initially infected node
            // use maximum subtree depth as the initial amount value
            amount = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0) {
            // this subtree does not contain infected node
            // return maximum subtree depth for further calculations
            return Math.max(left, right) + 1;
        } else {
            // one of the subtrees contains initially infected node
            // sum depth of initially infected node (negative value) and max depth of the other subtree (positive value)
            amount = Math.max(amount, Math.abs(left - right));
            return Math.min(left, right) - 1;
        }
    }
}
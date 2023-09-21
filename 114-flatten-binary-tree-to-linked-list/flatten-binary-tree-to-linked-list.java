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
    public void flatten(TreeNode root) {
    // Initialize a current node pointer to the root of the binary tree.
    TreeNode cur = root;
    
    // While the current node pointer is not null (there are still nodes to process):
    while (cur != null) {
        // Check if the current node has a left child.
        if (cur.left != null) {
            // Find the rightmost node in the left subtree of the current node.
            TreeNode last = cur.left;
            while (last.right != null) {
                last = last.right;
            }
            
            // Connect the right subtree of the current node to the rightmost node
            // of its left subtree.
            last.right = cur.right;
            
            // Move the entire left subtree to become the new right subtree of
            // the current node and set the left subtree of the current node to null.
            cur.right = cur.left;
            cur.left = null;
        }
        
        // Move the current node pointer to the right child (or the new right subtree).
        cur = cur.right;
    }
}
}
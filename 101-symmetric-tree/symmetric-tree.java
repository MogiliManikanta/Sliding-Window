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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left,root.right);
    }
    public boolean isSymmetricHelp(TreeNode p,TreeNode q){
        if(p==null || q==null){
            return p==q;
        }
        if(p.val != q.val){
            return false;
        }

        return isSymmetricHelp(p.left,q.right) && isSymmetricHelp(p.right,q.left);
    }
}
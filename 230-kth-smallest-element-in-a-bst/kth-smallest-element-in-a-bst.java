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
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,new int[]{k});
    }

    public int helper(TreeNode root,int[] k){
        if(root==null){
            return -1;
        }
        int result = helper(root.left,k);//finding in left
        if(result!=-1){
            return result;
        }
        if(k[0]==1){
            return root.val;
        }
        k[0]--;
        return helper(root.right,k); //finding right
    }
}
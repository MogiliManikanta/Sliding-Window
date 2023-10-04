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
    private int result=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        makeSumTree(root,0);
        return result;
    }
    private void makeSumTree(TreeNode root,int temp){
        if(root==null){
            return;
        }
        temp=temp*10+root.val;
        if(root.left==null && root.right==null){
            result+=temp;
        }
        makeSumTree(root.left,temp);
        makeSumTree(root.right,temp);
    }
}
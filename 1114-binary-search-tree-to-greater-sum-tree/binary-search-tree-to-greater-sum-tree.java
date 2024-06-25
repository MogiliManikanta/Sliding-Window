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
    static int size = 0;
    static int itr = 0;
    private void size(TreeNode root){
        if(root!=null){
            size(root.left);
            size++;
            size(root.right);
        }
    }
    private void traverse(TreeNode root,int arr[]){
        if(root!=null){
            traverse(root.left,arr);
            arr[itr++]=root.val;
            traverse(root.right,arr);
        }
    }
    private void fill(TreeNode root,int arr[]){
        if(root!=null){
            fill(root.left,arr);
            root.val = arr[itr++];
            fill(root.right,arr);
        }
    }
    public TreeNode bstToGst(TreeNode root) {
        size = itr = 0;
        size(root);
        int arr[] = new int[size];
        traverse(root,arr);
        for(int i=size-2;i>=0;i--){
            arr[i]+=arr[i+1];
        }
        itr = 0;
        fill(root,arr);
        return root;
    }
}
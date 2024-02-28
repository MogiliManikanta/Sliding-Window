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
  int lvl=0;
          int max=0;
    public int findBottomLeftValue(TreeNode root) {
      //if(root.left==null && root.right==null) return root.val;
      max=root.val;
        helper(root,0);
        return max;
    }
    void helper(TreeNode r,int currlvl){
      if(r==null) return;
      if(lvl<=currlvl){
        max=r.val;
        lvl=currlvl;
      }
      currlvl++;
      helper(r.right,currlvl);
      helper(r.left,currlvl);
    }
}

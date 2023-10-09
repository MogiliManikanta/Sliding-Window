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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return result;
        }
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> data = new LinkedList<>();
            while(size>0){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                size--;
                if(level%2==0){
                    data.add(temp.val);
                }
                else{
                    data.addFirst(temp.val);
                }
            }
            level++;
            result.add(data);
        }
        return result;
    }
}
/***

If level is even (the remainder of level divided by 2 is 0), then the value temp.val is added to the end of the data collection using the add method. This means that the values with even levels will be added to the end of the collection.

If level is odd (the remainder of level divided by 2 is not 0), then the value temp.val is added to the beginning of the data collection using the addFirst method. This means that the values with odd levels will be added to the beginning of the collection.

 */
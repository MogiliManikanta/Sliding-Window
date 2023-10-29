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
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new LinkedList<>();
		 return helper2(root,targetSum,path);	    
    }
    private int helper2(TreeNode root, int sum, List<Integer> path) {
		if(root==null) {
			return 0;
		}
		path.add(root.val);//add the node to the list
		long count=0;
		long compareSum=0;
		 
		 //calculating the no of paths I make
		 ListIterator<Integer> itr = path.listIterator(path.size());
		// taking the last element from list compare with sum if == increase count
		 while(itr.hasPrevious()) {
			 compareSum +=itr.previous();
			 if(compareSum==sum) {
				 count++;
			 }
		 }
		 //get the count value from left and right child 
		 count += helper2(root.left, sum, path) + helper2(root.right,sum,path);
		 
 //before return the count do backtrack because i am updating the same list instead to creating a new one
		 path.remove(path.size()-1);
		  
		 return (int)count;
	}
}
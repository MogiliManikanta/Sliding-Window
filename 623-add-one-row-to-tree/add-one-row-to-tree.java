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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            // If the depth is 1, create a new root node with the value 'v'
            // and make the original tree the left child of the new root.
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        d = d - 1; // Decrement d by 1 to work with the level before the target depth
        qu.offer(root);
        int level = 1;

        // Traverse the tree until you reach the level just before the target depth (d)
        while (level != d) {
            int size = qu.size();
            level++;
            while (size-- > 0) {
                TreeNode head = qu.poll();
                if (head.left != null) {
                    qu.offer(head.left);
                }
                if (head.right != null) {
                    qu.offer(head.right);
                }
            }
        }

        // At this point, 'qu' contains all nodes at the level just before the target depth (d)

        while (!qu.isEmpty()) {
            TreeNode head = qu.poll();
            TreeNode leftChild = head.left;
            TreeNode rightChild = head.right;

            // Create new nodes with the value 'v'
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);

            // Update the structure of the current node to insert the new nodes
            head.left = newLeft;
            head.right = newRight;

            // Connect the new nodes to the original left and right children
            newLeft.left = leftChild;
            newRight.right = rightChild;
        }

        return root; // Return the modified tree
    }
}

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
// import java.util.Stack;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

public class Solution {
    public TreeNode recoverFromPreorder(String tr) {
        Stack<TreeNode> stack = new Stack<>();

        for (int i = 0; i < tr.length(); ) {
            // Calculate the depth
            int depth = 0;
            while (i < tr.length() && tr.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Calculate the integer number
            int num = 0;
            while (i < tr.length() && tr.charAt(i) != '-') {
                num = num * 10 + (tr.charAt(i) - '0');
                i++;
            }

            // Create a node with value = num
            TreeNode node = new TreeNode(num);

            // While stack size > depth, pop nodes from stack
            // Because we can only link the current "node" to its previous depth parent,
            // so we need to pop until stack size == depth
            while (!stack.isEmpty() && stack.size() > depth) {
                stack.pop();
            }

            // If parent's left child is null, assign the current child "node" as the left child
            if (!stack.isEmpty() && stack.peek().left == null) {
                stack.peek().left = node;
            }
            // If the parent's left child is already assigned, it won't be null, right?
            // So you need to assign the parent's right child as the current "node"
            else if (!stack.isEmpty() && stack.peek().left != null) {
                stack.peek().right = node;
            }

            stack.push(node);
        }

        // We need to return the root node, so pop all other nodes first
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
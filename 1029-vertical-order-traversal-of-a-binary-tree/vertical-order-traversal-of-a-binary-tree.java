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
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
        
//     }
// }
class Tuple {
    TreeNode node;
    int row;
    int col;
    
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

public class Solution {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to store nodes based on horizontal position (x)
        // Each horizontal position maps to another TreeMap, which stores nodes based on vertical position (y)
        // PriorityQueues are used to keep nodes at the same vertical position sorted by their values.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for performing BFS traversal of the tree
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); // Start with the root node at position (0, 0)

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            // Create TreeMap for horizontal position (x) if it doesn't exist
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            // Create PriorityQueue for vertical position (y) if it doesn't exist
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            // Add the node's value to the PriorityQueue at the current position
            map.get(x).get(y).offer(node.val);

            // Enqueue left child with updated positions
            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }

            // Enqueue right child with updated positions
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Prepare the final result list
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list; // Return the list of nodes organized by vertical levels
    }
}

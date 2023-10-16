/*
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

public class Solution {
    public Node connect(Node root) {
        Node prev = ConnectChildren(root);
        while(prev != null){
            //Console.WriteLine("connecting children " + prev.val);
            prev = ConnectChildren(prev);
        }

        return root;
    }

    private static Node ConnectChildren(Node curr){
        Node parent = curr;
        Node prev = null;
        Node first = null;
        while(parent != null){
            if(parent.left != null){
                if(prev == null){
                    prev = parent.left;
                    first = prev;
                }else{
                    prev.next = parent.left;
                    prev = prev.next;
                }
            }

            if(parent.right != null){
                if(prev == null){
                    prev = parent.right;
                    first = prev;
                }else{
                    prev.next = parent.right;
                    prev = prev.next;
                }
            }

            parent = parent.next;
        }

        return first;
    }
}
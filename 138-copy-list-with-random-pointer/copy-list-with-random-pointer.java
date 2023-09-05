/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node temp = head;
        while (temp != null) {
            Node tempNew = new Node(temp.val);
            tempNew.next = temp.next;
            temp.next = tempNew;
            temp = temp.next.next;
        }
        // Update the random pointer
        Node newHead = head.next;
        temp = head;
        while (temp != null) {
            Node next = temp.next;
            if (temp.random != null) 
                next.random = temp.random.next;
            temp = next.next;
        }
        // Unwinding the list or separating the two lists
        temp = head;
        while (temp != null) {
            // temp.next = temp.next.next;
            Node copy = temp.next;
            temp.next = copy.next;
            if (copy.next != null) {
                copy.next = temp.next.next;
            }
            temp = temp.next;
        }
        return newHead;
    }
}
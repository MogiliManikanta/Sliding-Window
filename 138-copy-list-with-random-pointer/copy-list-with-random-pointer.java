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
        // Check if the input linked list is empty. If so, return null.
        if (head == null) return head;

        // Step 1: Duplicate each node and insert it between the original nodes.
        Node temp = head;
        while (temp != null) {
            // Create a new node with the same value as the original node.
            Node tempNew = new Node(temp.val);
            
            // Connect the new node to the next node in the original list.
            tempNew.next = temp.next;
            
            // Update the original node's next pointer to point to the new node.
            temp.next = tempNew;
            
            // Move to the next node in the original list (skip the duplicated node).
            temp = temp.next.next;
        }

        // Step 2: Update the random pointers of the duplicated nodes.
        // Set the newHead as the head of the duplicated list.
        Node newHead = head.next;
        temp = head;
        while (temp != null) {
            // Get the duplicated node (the one just after the original node).
            Node next = temp.next;
            
            // If the original node has a random pointer, update the duplicated node's random pointer.
            if (temp.random != null) 
                next.random = temp.random.next;
            
            // Move to the next original node (skip the duplicated node).
            temp = next.next;
        }

        // Step 3: Separate the original list from the duplicated list.
        temp = head;
        while (temp != null) {
            // Restore the original list's next pointer.
            Node copy = temp.next;
            temp.next = copy.next;
            
            // If there's a node after the duplicated node, update its next pointer.
            if (copy.next != null) {
                copy.next = temp.next.next;
            }
            
            // Move to the next original node (skip the duplicated node).
            temp = temp.next;
        }

        // Return the head of the duplicated list.
        return newHead;
    }
}
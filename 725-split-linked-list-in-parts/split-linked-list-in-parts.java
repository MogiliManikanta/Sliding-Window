/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Create an array to store the resulting list parts
        ListNode[] parts = new ListNode[k];
        
        // Calculate the length of the original linked list
        int length = 0;
        for (ListNode currentNode = head; currentNode != null; currentNode = currentNode.next)
            length++;
        
        // Calculate the minimum guaranteed size of each part and the number of extra nodes
        int minSize = length / k;
        int extraNodes = length % k;
        
        // Initialize pointers for traversing the original list and a previous node
        ListNode currentNode = head;
        ListNode previousNode = null;
        
        // Loop through each part
        for (int i = 0; currentNode != null && i < k; i++, extraNodes--) {
            // Store the current node as a part of the result
            parts[i] = currentNode;
            
            // Determine the number of nodes to include in this part (either minSize or minSize + 1)
            int nodesInPart = minSize + (extraNodes > 0 ? 1 : 0);
            
            // Traverse the list and update pointers accordingly
            for (int j = 0; j < nodesInPart; j++) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            
            // Set the next pointer of the previous node to null to separate the part from the rest of the list
            if (previousNode != null)
                previousNode.next = null;
        }
        
        // Return the array of list parts
        return parts;        
    }
}
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
    public ListNode mergeNodes(ListNode head) {
        // Initialize two pointers: prevNonZero (for tracking nodes with non-zero values) and current (for iterating through the list)
        for (ListNode prevNonZero = head, current = head.next; current != null; current = current.next) {
            // Check if the value of the current node is not equal to 0
            if (current.val != 0) {
                // If it's not equal to 0, add the value to the previous non-zero value node's value
                prevNonZero.val += current.val;
            } else {
                // If the value is 0, skip the current node by updating the next pointer of the previous non-zero value node
                prevNonZero.next = (current.next != null) ? current : null;
                // Move the prevNonZero pointer to the current node if its value is 0
                prevNonZero = current;
            }
        }
        // Return the modified linked list
        return head;
    }
}

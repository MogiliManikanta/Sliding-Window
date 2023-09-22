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
    public ListNode insertionSortList(ListNode head) {
        // Create a dummy node to serve as the starting point of the sorted list.
        ListNode dummy = new ListNode(0);
        // Initialize a 'prev' pointer to the dummy node.
        ListNode prev = dummy;

        // Iterate through the input list 'head'.
        while (head != null) {
            // Store the next node in the original list to avoid losing it.
            ListNode temp = head.next;

            // Check if the current node should be inserted at the beginning of the sorted list.
            if (prev.val >= head.val) {
                prev = dummy;
            }

            // Find the correct position to insert the current node in the sorted list.
            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }

            // Insert the current node into the sorted list.
            head.next = prev.next;
            prev.next = head;
            
            // Move to the next node in the original list.
            head = temp;
        }

        // The sorted list starts after the dummy node, so return dummy.next.
        return dummy.next;
    }
}

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
    // Helper function to reverse a linked list.
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;  // Store the next node.
            curr.next = prev;  // Reverse the current node's next pointer.
            prev = curr;       // Move prev to the current node.
            curr = next;       // Move curr to the next node.
        }
        return prev;  // Return the new head of the reversed list.
    }
    
    public void reorderList(ListNode head) {
        // Initialize two pointers, slow and fast.
        ListNode slow = head;
        ListNode fast = head; //(head != null) ? head.next : null;
        
        // Move slow one step at a time and fast two steps at a time until fast reaches the end.
        while (fast != null && fast.next != null) {
            slow = slow.next;     // Move slow one step.
            fast = fast.next.next; // Move fast two steps.
        }
        
        // After the loop, slow is at the middle of the linked list.
        // Reverse the second half of the linked list.
        ListNode second = reverse(slow.next);
        slow.next = null; // Cut off the first half from the second half.
        
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next; // Store the next node in the first half.
            ListNode temp2 = second.next; // Store the next node in the second half.
            
            first.next = second; // Connect the current node in the first half to the second half.
            second.next = temp1; // Connect the current node in the second half to the first half.
            
            first = temp1; // Move the first pointer to the next node in the first half.
            second = temp2; // Move the second pointer to the next node in the second half.
        }
    }
}
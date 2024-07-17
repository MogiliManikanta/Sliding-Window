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
    public boolean isPalindrome(ListNode head) {
        // Check if the linked list is
        // empty or has only one node
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }
    
        // Initialize two pointers, slow and fast,
        // to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
    
        // Traverse the linked list to find the
        // middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step at a time
            slow = slow.next;
    
            // Move fast pointer two steps at a time
            fast = fast.next.next;
        }
    
        // Reverse the second half of the 
        // linked list starting from the middle
        ListNode newHead = reverseLinkedList(slow.next);
    
        // Pointer to the first half
        ListNode first = head;
    
        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            // Compare data values of
            // nodes from both halves
    
            // If values do not match, the
            // list is not a palindrome
            if (first.val != second.val) {
                
                // Reverse the second half back
                // to its original state
                reverseLinkedList(newHead);
    
                // Not a palindrome
                return false;
            }
    
            // Move the first pointer
            first = first.next;
    
            // Move the second pointer
            second = second.next;
        }
    
        // Reverse the second half back
        // to its original state
        reverseLinkedList(newHead);
    
        // The linked list is a palindrome
        return true;
    }
    // Function to reverse a linked list
    // using the recursive approach
    public ListNode reverseLinkedList(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {

            // No change is needed;
            // return the current head
            return head;
        }

        // Recursive step: Reverse the remaining
        // part of the list and get the new head
        ListNode newHead = reverseLinkedList(head.next);

        // Store the next node in 'front'
        // to reverse the link
        ListNode front = head.next;

        // Update the 'next' pointer of 'front' to
        // point to the current head, effectively
        // reversing the link direction
        front.next = head;

        // Set the 'next' pointer of the
        // current head to 'null' to
        // break the original link
        head.next = null;

        // Return the new head obtained
        // from the recursion
        return newHead;
    }
}
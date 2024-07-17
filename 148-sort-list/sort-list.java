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
public class Solution {
    ListNode findMiddle(ListNode head){
        // If the list is empty or has only one node
        // the middle is the head itself
        if (head == null || head.next == null) {
            return head;
        }

        // Initializing slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Move the fast pointer twice
        // as fast as the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // When the fast pointer reaches the end,
        // the slow pointer will be at the middle
        return slow;
    }
  
  public ListNode sortList(ListNode head) {
    // Base case: if the list is empty or
    // has only one node, it is already
    // sorted, so return the head
    if (head == null || head.next == null) {
        return head;
    }
    
    // Find the middle of the list
    // using the findMiddle function
    ListNode middle = findMiddle(head);
    
    // Divide the list into two halves
    ListNode right = middle.next;
    middle.next = null;
    ListNode left = head;
    
    // Recursively sort the left and right halves
    left = sortList(left);
    right = sortList(right);
    
    // Merge the sorted halves using the
    // mergeTwoSortedLinkedLists function
    return merge(left,right);
  }
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null)
      p.next = l1;
    if (l2 != null)
      p.next = l2;
    return l.next;
  }
}
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Check if the input array 'lists' is null or empty. If so, return null.
        if (lists == null || lists.length == 0) return null;
        
        // Initialize the 'interval' variable to 1.
        int interval = 1;
        
        // Merge the lists iteratively in a divide-and-conquer manner.
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                // Merge two lists: 'lists[i]' and 'lists[i+interval]'
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            // Double the interval for the next iteration.
            interval *= 2;
        }
        
        // After merging all lists, the result is stored in 'lists[0]'.
        // Return the merged list.
        return lists[0];
    }
    
    // Helper function to merge two sorted lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // If either of the input lists is null, return the other list.
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        
        // Create a dummy node to simplify list manipulation.
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; // Initialize 'curr' to the dummy node.
        
        // Merge the two lists while maintaining the sorted order.
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; // Move 'curr' to the next node in the merged list.
        }
        
        // Append the remaining nodes from either list if any.
        curr.next = l1 == null ? l2 : l1;
        
        // Return the merged list starting from the node after the dummy node.
        return dummy.next;
    }
}
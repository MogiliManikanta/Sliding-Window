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
class Solution
{
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        
        ListNode odd_last = head;
        ListNode even_last = head.next, even_start = head.next;
        if(even_start == null || even_start.next == null) 
            return head;
        
        ListNode curr = even_last.next;
        boolean odd = true;
        while(curr != null) {
            if(odd) {
                odd_last.next = curr;
                odd_last = odd_last.next;
            }
            else {
                even_last.next = curr;
                even_last = even_last.next;
            }
            curr = curr.next;
            odd = !odd;
        }
        
        even_last.next = null;
        odd_last.next = even_start;
        return head;
    }
}
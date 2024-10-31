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
        if(head==null || head.next==null) return true;
        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle.next);
        ListNode first=head;
        while(second!=null){
            if(first.val != second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode new_Node = reverse(head.next);
        ListNode front = head.next;
        front.next=head;
        head.next=null;
        return new_Node;
    }
    public ListNode findMiddle(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
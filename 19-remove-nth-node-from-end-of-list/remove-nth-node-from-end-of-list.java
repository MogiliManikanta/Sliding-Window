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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode current = head;
        int count=0;
        while(current != null){
            count++;
            current=current.next;
        }
        if(count==n){
            return head.next;
        }
        current=head;
        int res=count-n;
        while(current != null){
            res--;
            if(res==0){
                break;
            }
            current=current.next;
        }
        current.next=current.next.next;
        return head;
    }
}
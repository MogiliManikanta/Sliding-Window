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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null  || k==0){
            return head;
        }
        int length=0;
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while(fast.next!=null){
            fast=fast.next;
            length++;
        }
        for(int j=length-(k%length);j>0;j--){
            slow=slow.next;
        }
        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;
        return dummy.next;
    }
}
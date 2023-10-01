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
    public ListNode reverse(ListNode head,int k,int length){
        if(length<k){
            return head;
        }
        ListNode current=head,next=null,prev=null;
        int count=0;
       while(current!=null && count<k){
           next=current.next;
           current.next=prev;
           prev=current;
           current=next;
           count++;
       }
       if(next!=null){
           head.next=reverse(next,k,length-k);
       }
       return prev; 
    }
    public ListNode reverseKGroup(ListNode head, int k) {
       int length = linkedListLength(head);
       ListNode result = reverse(head,k,length);
       return result;
    }
    public int linkedListLength(ListNode head){
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        return length;
    }
}
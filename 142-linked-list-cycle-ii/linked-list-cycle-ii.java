/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if(head==null|| head.next==null){
           return null;
       }
       ListNode slow=head;
       ListNode fast=head;
       while(fast.next!=null && fast.next.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(fast==slow){
               ListNode dummy =head;
               while(dummy!=slow){
                   slow=slow.next;
                   dummy=dummy.next;
               }
               return slow;
           }
       }
       return null;
    }
}
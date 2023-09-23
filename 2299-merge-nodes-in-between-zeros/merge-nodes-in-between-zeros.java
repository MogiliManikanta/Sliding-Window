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
    public ListNode mergeNodes(ListNode head) {
        for(ListNode p_z = head,p=head.next;p!=null;p=p.next){
            if(p.val!=0){
                p_z.val+=p.val;
            }
            else{
                p_z.next = p.next!=null?p:null;
                p_z=p;
            }
        }
        return head;
    }
}
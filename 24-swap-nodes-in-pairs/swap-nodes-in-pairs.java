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
    public ListNode swapPairs(ListNode head) {
      if(head==null || head.next==null){
          return head;
      }
      ListNode dummy = new ListNode();
      ListNode prevNode = dummy,currNode = head;
      while(currNode != null && currNode.next!=null){
          prevNode.next=currNode.next;
          currNode.next=prevNode.next.next;
          prevNode.next.next=currNode;

          prevNode=currNode;
          currNode=currNode.next;
      }
      return dummy.next;  
    }
}
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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groupRequired = 1;
        ListNode temp = head;
        while(temp!=null){
            int count =0;
            ListNode start = temp;
            Stack<Integer> stack = new Stack<>();
            while(count!=groupRequired && temp!=null){
                stack.push(temp.val);
                temp=temp.next;
                count++;
            }
            if(count%2==0){
                while(start!=temp){
                    start.val=stack.pop();
                    start=start.next;
                }
            }
            groupRequired++;
        }
        return head;
    }
}
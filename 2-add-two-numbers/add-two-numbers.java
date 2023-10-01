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
    static ListNode reverse(ListNode head)
    {
        ListNode prev=null,curr=head,next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    //Function to add two numbers represented by linked list.
    static ListNode addTwoNumbers(ListNode first, ListNode second)
    {
       //first=reverse(first);
       //second=reverse(second);
       ListNode sum=null;
       int carry=0;
       while(first!=null || second!=null || carry>0)
       {
           int newVal=carry;
           if(first!=null)
                newVal+=first.val;
            if(second!=null)
                newVal+=second.val;
            carry=newVal/10;
            newVal=newVal%10;
            ListNode newNode=new ListNode(newVal);
            newNode.next=sum;
            sum=newNode;
            if(first!=null)
                first=first.next;
            if(second!=null)
                second=second.next;
       }
       sum=reverse(sum);
       return sum;
    }
}
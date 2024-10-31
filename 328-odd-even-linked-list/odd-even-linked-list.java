class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Separate pointers for odd and even lists
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // Keep a reference to the start of the even list

        while (even != null && even.next != null) {
            odd.next = even.next;     // Link odd to the next odd node
            odd = odd.next;           // Move odd pointer forward
            even.next = odd.next;     // Link even to the next even node
            even = even.next;         // Move even pointer forward
        }
        odd.next = evenHead;          // Link the end of the odd list to the head of the even list

        return head;  // Return the modified list starting from the head
    }
}

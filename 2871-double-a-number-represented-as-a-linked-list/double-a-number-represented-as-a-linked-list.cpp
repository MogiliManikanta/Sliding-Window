class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* current = head;
        while (current != nullptr) {
            ListNode* nextNode = current->next;
            current->next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
}
    ListNode* doubleIt(ListNode* head) {
        if (!head)
            return head;

        head = reverseList(head);

        ListNode* current = head;
        ListNode* newHead = nullptr;
        int carry = 0;

        while (current != nullptr) {
            int newVal = current->val * 2 + carry;
            carry = newVal / 10;
            newVal %= 10;

            if (newHead == nullptr) {
                newHead = new ListNode(newVal);
            } else {
                ListNode* newNode = new ListNode(newVal);
                newNode->next = newHead;
                newHead = newNode;
            }

            current = current->next;
        }

        if (carry > 0) {
            ListNode* newNode = new ListNode(carry);
            newNode->next = newHead;
            newHead = newNode;
        }

        return newHead;
    }
};

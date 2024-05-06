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
    public ListNode removeNodes(ListNode head) {
    ListNode tmp = new ListNode(Integer.MAX_VALUE);
    List<ListNode> st = new ArrayList<>();
    st.add(tmp);
    
    ListNode p = head;
    while (p != null) {
        while (!st.isEmpty() && st.get(st.size() - 1).val < p.val) {
            st.remove(st.size() - 1);
        }
        
        st.get(st.size() - 1).next = p;
        st.add(p);
        
        p = p.next;
    }
    
    return tmp.next;
}

}
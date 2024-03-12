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
    public ListNode removeZeroSumSublists(ListNode head) {
        // Create a dummy node to handle edge cases more easily
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        dummy.next = head; // Connect the dummy node to the head of the linked list
        int prefixSum = 0; // Initialize a variable to keep track of the prefix sum
        Map<Integer, ListNode> prefixSumMap = new HashMap<>(); // Create a HashMap to store prefix sums and corresponding nodes
        
        while (current != null) {
            prefixSum += current.val; // Update the prefix sum with the current node's value
            
            if (prefixSumMap.containsKey(prefixSum)) {
                // If the prefix sum has been seen before, it means there is a sublist with a sum of 0
                ListNode startNode = prefixSumMap.get(prefixSum).next; // Get the starting node of the sublist
                int tempSum = prefixSum + startNode.val; // Initialize a temporary sum
                while (tempSum != prefixSum) {
                    // Remove all nodes between the starting node and the current node from the HashMap
                    prefixSumMap.remove(tempSum);
                    startNode = startNode.next;
                    tempSum += startNode.val;
                }
                // Update the next pointer of the previous node to skip the sublist
                prefixSumMap.get(prefixSum).next = current.next;
            } else {
                // If the prefix sum is encountered for the first time, add it to the HashMap along with the current node
                prefixSumMap.put(prefixSum, current);
            }
            
            current = current.next; // Move to the next node in the linked list
        }
        
        return dummy.next; // Return the modified linked list, skipping zero-sum sublists
    }
}
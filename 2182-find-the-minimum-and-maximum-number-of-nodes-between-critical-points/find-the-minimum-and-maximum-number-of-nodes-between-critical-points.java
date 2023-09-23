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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Initialize the result array with default values
        int result[] = new int[]{-1, -1};
        
        // Check for the base case: if the list is empty or has fewer than 3 nodes, return the default result
        if (head == null || head.next == null || head.next.next == null)
            return result;
        
        // Initialize variables to keep track of minimum and current critical point indices, and the last critical point index
        int minIndex = Integer.MAX_VALUE;
        int currentIndex = -1;
        int lastIndex = -1;
        
        // Initialize variables to traverse the linked list
        ListNode previousNode = head;
        ListNode currentNode = head.next;
        
        // Initialize an index counter
        int currentIndexCounter = 1;
        
        // Initialize a variable to keep track of the minimum distance between critical points
        int minDistance = Integer.MAX_VALUE;
        
        // Traverse the linked list until the second-to-last node
        while (currentNode != null && currentNode.next != null) {
            // Check if the current node is a critical point (either a local maximum or local minimum)
            if ((currentNode.val > previousNode.val && currentNode.val > currentNode.next.val) ||
                (currentNode.val < previousNode.val && currentNode.val < currentNode.next.val)) {
                
                // Update the minimum critical point index
                if (currentIndexCounter < minIndex)
                    minIndex = currentIndexCounter;
                
                // Update the last critical point index
                lastIndex = currentIndex;
                
                // Update the current critical point index
                currentIndex = currentIndexCounter;
                
                // If there was a previous critical point, calculate the distance between them
                if (lastIndex != -1 && currentIndex - lastIndex < minDistance)
                    minDistance = currentIndex - lastIndex;
            }
            
            // Move to the next nodes and increment the index counter
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIndexCounter++;
        }
        
        // Check if there was at least one critical point found
        if (lastIndex != -1) {
            // Update the result array with the minimum distance between critical points and the range between the first and last critical points
            result[0] = minDistance;
            result[1] = currentIndex - minIndex;
        }
        
        // Return the result array
        return result;
    }
}
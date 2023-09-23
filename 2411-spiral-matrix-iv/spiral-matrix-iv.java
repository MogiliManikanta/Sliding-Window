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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
    // Initialize a 2D array to store the result
    int[][] matrix = new int[m][n];
    for(int i[] : matrix){
        Arrays.fill(i,-1);
    }
    // Initialize variables for current row and column
    int row = 0, col = 0;
    
    // Initialize variables to define the boundaries of the spiral
    int top = 0, left = 0, bottom = m - 1, right = n - 1;

    // Iterate through the linked list while filling the matrix in a spiral order
    while (head != null) {
        // Assign the value from the linked list node to the current position in the matrix
        matrix[row][col] = head.val;
        
        // Move to the next node in the linked list
        head = head.next;
        
        // Check which direction we should move in the spiral
        if (row == top && col < right) {
            // Move right within the top row
            col++;
            if (col == right) top++;
        } else if (col == right && row < bottom) {
            // Move down within the rightmost column
            row++;
            if (row == bottom) right--;
        } else if (row == bottom && col > left) {
            // Move left within the bottom row
            col--;
            if (col == left) bottom--;
        } else if (col == left && row > top) {
            // Move up within the leftmost column
            row--;
            if (row == top) left++;
        }
    }
    
    // Return the filled matrix in a spiral order
    return matrix;
}
}
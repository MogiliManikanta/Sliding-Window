class Solution {
    public int nextGreaterElement(int n1) {
        // Convert the integer 'n1' to a character array.
        char nums[] = (n1 + "").toCharArray();
        int n = nums.length;
        int index1 = -1; // Initialize index1 to -1.
        int index2 = -1; // Initialize index2 to -1.

        // Find the first index 'index1' where the digit is smaller than the digit to its right.
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }
        // If 'index1' is still -1, it means the number is in decreasing order, and no greater number can be formed.
        if (index1 == -1) {
            return -1;
        } else {
            // Find the index 'index2' for the next greater digit to swap with.
            for (int i = n - 1; i > index1; i--) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }
            // Swap the digits at 'index1' and 'index2'.
            swap(nums, index1, index2);
            // Reverse the digits to the right of 'index1' to get the smallest greater number.
            reverse(nums, index1 + 1);
        }
        // Convert the character array back to a long number.
        long number = Long.parseLong(new String(nums));
        // Check if the number is greater than the maximum value of an integer.
        // If it is, return -1; otherwise, return the integer value.
        return number > Integer.MAX_VALUE ? -1 : (int) number;
    }

    // Helper function to swap two elements in the character array.
    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse a portion of the character array starting from 'left' index.
    public void reverse(char[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            char temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
/**Here's how the code works step by step:

It starts by converting the integer n1 to a character array nums to work with individual digits.

It finds the length n of the character array nums.

It initializes two indices, index1 and index2, to -1. These indices will be used to identify the positions for swapping digits.

It iterates from right to left through the digits in the character array to find the first index index1 where the digit is smaller than the digit to its right. This is the starting point for rearranging the digits.

If index1 is still -1 after the loop, it means that all digits are in decreasing order (no greater number can be formed), and it returns -1.

If index1 is not -1, it means a swap can be made to get a greater number. It then searches for the smallest digit to the right of index1 that is greater than the digit at index1. This is identified as index2.

It swaps the digits at index1 and index2 to create a new arrangement of digits.

It reverses the digits to the right of index1 to make sure that the rearranged number is the smallest greater number possible.

The character array is converted back to a long number called number.

It checks if number is greater than Integer.MAX_VALUE. If it is, it returns -1 to indicate that the result is too large for an integer. Otherwise, it returns the integer value of number.

In summary, this code finds the next greater number by rearranging the digits of the input integer, ensuring it is the smallest possible greater number, and handling edge cases where the result might exceed the maximum integer value. */
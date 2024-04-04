/*class Solution {
    public int[] singleNumber(int[] nums) {
        
    }
}*/
class Solution {
    public int[] singleNumber(int[] Arr) {
        int[] result = new int[2];
        int N = Arr.length;
        // Calculate XOR of all elements in the array
        int numXor = 0;
        for (int num : Arr) {
            numXor ^= num;
        }

        // Find the rightmost set bit
        int rightBit = numXor & -numXor;

        // Separate the numbers into two groups based on the rightmost set bit
        int a = 0, b = 0;
        for (int num : Arr) {
            if ((num & rightBit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        result[0] = a;
        result[1] = b;
        return result;
    }
}

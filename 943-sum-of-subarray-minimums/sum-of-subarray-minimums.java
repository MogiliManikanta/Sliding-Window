import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] prevSmaller = calculatePrevSmallerElements(arr);
        int[] nextSmaller = calculateNextSmallerElements(arr);
      
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i < length; ++i) {
            answer += (long) (i - prevSmaller[i]) * (nextSmaller[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
  
    private int[] calculatePrevSmallerElements(int[] arr) {
        int length = arr.length;
        int[] prevSmaller = new int[length];
        Arrays.fill(prevSmaller, -1);
        Deque<Integer> stack = new ArrayDeque<>();
      
        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
      
        return prevSmaller;
    }
  
    private int[] calculateNextSmallerElements(int[] arr) {
        int length = arr.length;
        int[] nextSmaller = new int[length];
        Arrays.fill(nextSmaller, length);
        Deque<Integer> stack = new ArrayDeque<>();
      
        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
      
        return nextSmaller;
    }
}

class Solution {
    public int totalStrength(int[] strengths) {
    int totalStrength = 0, currentAccumulation = 0, mod = (int)1e9 + 7, n = strengths.length;
    Stack<Integer> stack = new Stack<>();
    int[] accumulatedStrengths = new int[n + 2];
    
    for (int r = 0; r <= n; ++r) {
        int currentStrength = r < n ? strengths[r] : 0;
        currentAccumulation = (currentAccumulation + currentStrength) % mod;
        accumulatedStrengths[r + 1] = (currentAccumulation + accumulatedStrengths[r]) % mod;
        
        while (!stack.isEmpty() && strengths[stack.peek()] > currentStrength) {
            int i = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            long leftAccumulation = left < 0 ? accumulatedStrengths[i] : accumulatedStrengths[i] - accumulatedStrengths[left];
            long rightAccumulation = accumulatedStrengths[r] - accumulatedStrengths[i];
            int leftCount = i - left, rightCount = r - i;
            totalStrength = (int)(totalStrength + (rightAccumulation * leftCount - leftAccumulation * rightCount) % mod * strengths[i] % mod) % mod;
        }
        stack.push(r);
    }
    
    return (totalStrength + mod) % mod;
}
}
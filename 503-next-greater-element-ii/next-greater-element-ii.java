class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer>stack = new Stack<>();
        int result[] = new int[n];
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
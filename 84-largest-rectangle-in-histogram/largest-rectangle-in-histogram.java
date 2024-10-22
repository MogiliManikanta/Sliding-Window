class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse = nextSmallerElement(heights);
        int[] pse = previousSmallerElement(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int height = heights[i];
            int width = nse[i] - pse[i] - 1; // Calculate width between the next and previous smaller elements
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int[] nextSmallerElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n=nums.length;
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] previousSmallerElement(int[] nums){
        int n=nums.length;
        int[] result=new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return result;
    }
}
/**
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(maxArea,minHeight*(j-i+1));
            }
        }
        return maxArea;
    }
} */
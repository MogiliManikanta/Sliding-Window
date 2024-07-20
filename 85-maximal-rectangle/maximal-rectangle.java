class Solution {
    public int largestHistogramRectangle(int[] heights){
        int n = heights.length;
        Stack<Integer>stack = new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || heights[i]<=heights[stack.peek()])){
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()){
                    width=i;
                }
                else{
                    width=i-stack.peek()-1;
                }
                maxArea = Math.max(maxArea,width*height);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int height[] = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    height[j]=0;
                    continue;
                }
                else{
                    height[j]++;
                }
            }
            int area = largestHistogramRectangle(height);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
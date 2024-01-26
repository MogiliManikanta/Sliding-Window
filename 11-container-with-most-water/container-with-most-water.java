class Solution {
    public int maxArea(int[] height) {
       int left=0;
       int right=height.length-1;
       int maxArea=Integer.MIN_VALUE;
       //int area=0;
       while(left<right){
           int area=Math.min(height[left],height[right])*(right-left);// calculating the small one from right & left and and distance like this
           maxArea=Math.max(area,maxArea);
           if(height[left]<height[right]){
               left++; // incrementing the left 
           }
           else{
               right--;
           }
       }
       return maxArea; 
    }
}
/**1.The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.


2.All other containers are less wide and thus would need a higher water level in order to hold more water.


3.The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration

1.done
*/
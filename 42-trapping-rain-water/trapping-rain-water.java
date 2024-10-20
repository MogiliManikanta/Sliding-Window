class Solution {
    public int trap(int[] height) {
       int left=0,right=height.length-1;
       int leftMax = 0,rightMax = 0;
       int result = 0;
       while(left<right){
        if(height[left]<=height[right]) {
            if(height[left]>leftMax) {
                leftMax = height[left];
            }
            else{
                result+=leftMax-height[left];
            }
            left++;
        }
        else{
           if(height[right]>rightMax) {
            rightMax = height[right];
           } 
           else {
            result += rightMax - height[right];
           }
           right--;
        }
       }
       return result; 
    }
}
/**

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        // int[] prefix = new int[n];
        // prefix[0]=arr[0];
        // for(int i=1;i<n;i++) {
        //     prefix[i] = Math.max(prefix[i-1],arr[i]); 
        // }
        suffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--) {
            suffix[i]=Math.max(suffix[i+1],arr[i]);
        }
        int left=0,right=n-1;
        int waterTrapped=0;
        int leftSum = arr[0];
        for(int i=0;i<n;i++) {
            leftSum=Math.max(leftSum,arr[i]);
            waterTrapped += Math.min(leftSum,suffix[i]) - arr[i];
        }
        return waterTrapped;
    }
} */
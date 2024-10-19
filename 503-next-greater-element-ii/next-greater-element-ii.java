class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer>stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]) {
                stack.pop();
            }
            if(i<n){
            if(stack.isEmpty()) {
                result[i]=-1;
            }
            else{
                result[i] = stack.peek();
            }}
            stack.push(nums[i%n]);
        }
        return result;
    }
}
/*class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            result[i] = -1;
            for(int j=i+1;j<=i+n-1;j++) {
                if(arr[j%n]>arr[i]){
                    result[i]=arr[j%n];
                    break;
                }
            }
        }
        return result;
    }
}*/
class Solution {
    public long subArrayRanges(int[] nums) {
        return sumOfSubArrayMaximum(nums) - sumOfSubArrayMinimum(nums);
    }
    public long sumOfSubArrayMaximum(int[] nums){
        int[] nge = nextGreaterNumber(nums);
        int[] pge = previousGreaterNumber(nums);
        long result=0;
        for(int i=0;i<nums.length;i++){
            long leftIndex = i-pge[i];
            long rightIndex = nge[i]-i;
            result = result + (leftIndex * rightIndex * nums[i] * 1L);
        }
        return result;
    }
    public int[] nextGreaterNumber(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            //explain
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public int[] previousGreaterNumber(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            // explain
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return result;
    }
    public long sumOfSubArrayMinimum(int[] nums){
        int[] pse = previousSmallerNumber(nums);
        int[] nse = nextSmallerNumber(nums);
        long result=0;
        for(int i=0;i<nums.length;i++){
            long leftIndex = i - pse[i];
            long rightIndex = nse[i]-i;
            result = result+(leftIndex * rightIndex * nums[i] *1L);
        }
        return result;
    }
    public int[] previousSmallerNumber(int[] nums){
        int n=nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            //explain
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    public int[] nextSmallerNumber(int[] nums){
        int n= nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            //explain
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return result;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index=0;
        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && deque.peek()==i-k){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
             deque.offer(i);
            if(i>=k-1){
                result[index++]=nums[deque.peek()];//deque.peekFirst() same as deque.peek();
            }
        }
        return result;
    }
}
/**class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result = new int[n-k+1];
        int index=0;
        for(int i=0;i<=n-k;i++){
            int max=-(int)1e9;
            for(int j=i;j<i+k;j++){
                max=Math.max(nums[j],max);
            }
            result[index++]=max;
        }
        return result;
    }
} */
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        long[] prefix = new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        } 
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n+1;i++){
            while(deque.size()>0 && (prefix[i]-prefix[deque.peekFirst()])>=k){
                result=Math.min(result,i-deque.pollFirst());
            }
            while(deque.size()>0 && (prefix[deque.peekLast()])>=prefix[i]){
                deque.pollLast();
            }
            deque.add(i);
        }
        return result == Integer.MAX_VALUE?-1:result;

    }
}
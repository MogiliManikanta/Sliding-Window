class Solution {
    public static int sumSubarrayMins(int[] arr) 
    {
    int ans = 0;
        Stack<Integer> st = new Stack<>();
        long mod = (long)1000000007;
        st.push(-1);
        for (int i= 0; i < arr.length+1; i++){
            int currVal = (i<=arr.length-1)? arr[i] : 0;
            while(st.peek() !=-1 && currVal<arr[st.peek()]){
                int index = st.pop();
                int j = st.peek();
                int left = index - j;
                int right = i - index;
                long add = (left * right * (long)arr[index]) % mod;
                ans += add ;
                ans %= mod;
            }
            st.push(i);
        }
        return ans;
    }
}
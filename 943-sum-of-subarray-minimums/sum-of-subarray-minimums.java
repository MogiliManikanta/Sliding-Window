class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int []nse = nextSmallerElement(arr,n);
        int []pse = previousSmallerElement(arr,n);
        long result=0;
        int mod = (int)1e9+7;
        for(int i=0;i<n;i++) {
            long leftLen = i-pse[i];
            long rightLen = nse[i]-i;
            result +=  (leftLen * rightLen * arr[i])%mod;
            // answer += (long) (i - pse[i]) * (nse[i] - i) % mod * arr[i] % mod;
            // answer %= mod;
        }
        return (int)(result%mod);
    }
    public int[] previousSmallerElement(int[] arr,int n) {
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(pse,-1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                pse[i] = -1;
            }
            else {
                pse[i]=stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }

    public int[] nextSmallerElement(int[] arr,int n) {
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(nse,n);
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nse[i]=n;
            }
            else{
                nse[i]=stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }
}
/**class Solution {
    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        int mod = (int) 1e9+7;
        for(int i=0;i<arr.length;i++) {
            int mini = arr[i];
            for(int j=i;j<arr.length;j++) {
                mini = Math.min(arr[j],mini);
                result= (result + mini)%mod;
            }
        }
        return result;
    }
} */
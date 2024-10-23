class StockSpanner {
    Stack<Pair> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index=-1;
    }
    
    public int next(int price) {
        index++;
        int ans=0;
        while(!stack.isEmpty() && stack.peek().first<=price){
            stack.pop();
        }
        ans = stack.isEmpty()?index - -1:index - stack.peek().second;
        stack.push(new Pair(price,index));
        return ans;
    }
}
class Pair{
    int first;
    int second;
    public Pair(int f,int s){
        this.first=f;
        this.second=s;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 /**class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int ind;
    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    public int next(int price) {
        ind++;
        while(!st.isEmpty() && st.peek()[1]<=price)
            st.pop();
        int span = ind - (st.isEmpty()?-1:st.peek()[0]);
        st.push(new int[]{ind,price});
        return span;
    }
} */
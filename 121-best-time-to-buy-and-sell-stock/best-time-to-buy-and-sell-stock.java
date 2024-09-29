class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0,mini=(int) 1e9;
        for(int i=0;i<prices.length;i++) {
            mini = Math.min(mini,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-mini);
        }
        return maxProfit;
    }
}
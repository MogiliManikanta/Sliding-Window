class Solution {
    public int maxProfit(int[] prices) {
      int maxCurrent = 0;
      int maxSoFar = 0;
      for(int i=1;i<prices.length;i++){
          maxCurrent=Math.max(0,maxCurrent+=prices[i]-prices[i-1]);
          maxSoFar = Math.max(maxCurrent,maxSoFar);
      }
      return maxSoFar;  
    }
}
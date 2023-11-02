class Solution {

    public int shipWithinDays(int[] weights, int Days) {
        int left = max(weights);
        int right = sum(weights);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isFeasible(weights, Days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    public boolean isFeasible(int[] weights, int Days, int capacity) {
        int days = 1;
        int total = 0;
        
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                total = weight;
                days++;
                if (days > Days) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public int max(int[] weights){
        int maxValue=Integer.MIN_VALUE;
        for(int i : weights){
            maxValue=Math.max(maxValue,i);
        }
        return maxValue;
    }

    public int sum(int[] weights){
        int sumValue=0;
        for(int i:weights){
            sumValue+=i;
        }
        return sumValue;
    }
}

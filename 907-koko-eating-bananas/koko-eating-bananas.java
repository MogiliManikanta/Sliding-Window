class Solution {
    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0; // Hours take to eat all bananas at speed K.
        
        for (int pile : piles) {
            countHour += pile / K;
            if (pile % K != 0)
                countHour++;
        }
        return countHour <= H;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=max(piles);
        while(left<right){
            int mid=left+(right-left)/2;
            if(canEatAll(piles,mid,h)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    private int max(int[] nums){
        int maxValue=Integer.MIN_VALUE;
        for(int i:nums){
            maxValue=Math.max(i,maxValue);
        }
        return maxValue;
    }
}
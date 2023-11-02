class Solution {
    private boolean canEatAll(int[] piles, int speed, int H) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile - 1) / speed + 1;
        }
        return hours <= H;
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
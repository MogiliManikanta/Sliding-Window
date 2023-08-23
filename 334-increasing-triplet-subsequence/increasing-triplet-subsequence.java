class Solution {
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for(int n : nums){
            if(n<=firstNum){ // update small if n is smaller than both
                firstNum=n;
            }
            else if(n<=secondNum){ // update big only if greater than small but smaller than big
                secondNum=n;
            }
            else{
                return true; // return if you find a number bigger than both
            }
        }
        return false;
    }
}
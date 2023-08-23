class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for(int n : nums){
            if(n<=firstNum){
                firstNum=n;
            }
            else if(n<=secondNum){
                secondNum=n;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
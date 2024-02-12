class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return false;
        }
        for(int i=0;i<n;i++){
            int fast=i,slow=i;
            boolean iForward = nums[i]>=0;
            while(true){
                slow = getNextIndex(nums,slow,iForward);
                if(slow==-1){
                    break;
                }
                fast=getNextIndex(nums,fast,iForward);
                if(fast==-1) break;
                fast=getNextIndex(nums,fast,iForward);
                if(fast==-1) break;
                if(fast==slow) return true;
            }
        }
        return false;
    }
    public int getNextIndex(int[] nums,int index,boolean iForward){
        boolean direction = nums[index]>=0;
        if(direction!=iForward){
            return -1;
        }
        int nextIndex = (index+nums[index])%nums.length;
        if(nextIndex<0){
            nextIndex = nextIndex+nums.length;
        }
        if(nextIndex==index){
            return -1;
        }
        return nextIndex;
    }
}
class Solution {
    public boolean checkIfExist(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int ele : nums){
            if(set.contains(ele*2) || (ele%2==0 && set.contains(ele/2))){
                return true;
            }
            else{
                set.add(ele);
            }
        }
        return false;
    }
}

/**
    Just in case anyone is confused. The reason we also check for i / 2 is because we may have an array like [7,1,14,11] and if we just said n * 2 in seen, 14 isn't in seen yet so it would return false instead of true. So when we get to 14, 7 is already in it so our i/2 check will return True. That's why it can be done in one pass




 */
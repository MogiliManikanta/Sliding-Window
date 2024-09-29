class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int rem = target-nums[i];
            if(map.containsKey(rem)){
                int index1 = i;
                int index2 = map.get(rem);
                return new int[]{index1,index2};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
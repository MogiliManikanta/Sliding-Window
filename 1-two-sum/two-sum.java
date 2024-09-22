class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int find = target-nums[i];
            if(map.containsKey(find)){
                int index1 = i;
                int index2=map.get(find);
                return new int[]{index1,index2};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
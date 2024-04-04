class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         int subsets = 1<<nums.length;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<subsets;i++){
            ArrayList<Integer> subal = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    subal.add(nums[j]);
                }
            }
            al.add(subal);
        }
        return al;
    }
}
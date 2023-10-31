class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,new ArrayList<>(),list);
        return list;
    }
    private void helper(int[] nums,List<Integer>temp,List<List<Integer>>list){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                helper(nums,temp,list);
                temp.remove(temp.size()-1);
            }
        }
    }
}
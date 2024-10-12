class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right=n-1;
            while(left<right){
                long sum=nums[i];
                sum+=nums[left];
                sum+=nums[right];
                if(sum==0){
                    ArrayList<Integer>temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    left++;right--;
                    while(left<right && nums[left]==nums[left-1]) left++;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }
                else if(sum<0) left++;
                else right--;
            }
        }
        return list;
    }
}
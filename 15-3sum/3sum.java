class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // to sort
        List<List<Integer>>result = new ArrayList<>();
        int n= nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){ // to avoid duplicates
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer>temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    //result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    result.add(temp);
                    k--;
                    j++;
                    while(j<n && nums[j]==nums[j-1]){ // to avoid duplicates
                        j++;
                    }
                    while(k<n-2 && nums[k]==nums[k+1]){ // to avoid duplicates
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
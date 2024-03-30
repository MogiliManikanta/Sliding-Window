class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKInteger(nums,k)-atMostKInteger(nums,k-1);
    }
    public int atMostKInteger(int[] nums,int k){
        HashMap<Integer,Integer>count = new HashMap<>();
        int i=0,result=0;
        int n=nums.length;
        for(int j=0;j<n;j++){
            if(count.getOrDefault(nums[j],0)==0){
                k--;
            }
            count.put(nums[j],count.getOrDefault(nums[j],0)+1);
            while(k<0){
                count.put(nums[i],count.get(nums[i])-1);
                if(count.getOrDefault(nums[i],0)==0){
                    k++;
                }
                i++;
            }
            result+=j-i+1;
        }
        return result;
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int n=nums.length;
        map.put(sum,1);
        int cnt=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int remaining = sum-k;
            if(map.containsKey(remaining)){
                cnt+=map.get(remaining);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
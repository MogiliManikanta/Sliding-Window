class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum=0;
        int left=0,right=0,maxi=0,n=arr.length;
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(sum,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int remain =sum-k;
            if(map.containsKey(remain)){
                ans+=map.get(remain);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
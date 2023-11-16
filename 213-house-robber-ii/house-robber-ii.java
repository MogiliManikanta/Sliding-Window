class Solution {
    public int helper(ArrayList<Integer> nums){
        int prev1=nums.get(0);
        int prev2=0;
        for(int i=1;i<nums.size();i++){
            int pick=nums.get(i);
            if(i>1){
                pick+=prev2;
            }
            int notpick=0+prev1;
            int curr=Math.max(pick,notpick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
      int n=nums.length;
      if(n==1){
        return nums[0];
      }
       ArrayList<Integer>list1=new ArrayList<>();
       ArrayList<Integer>list2=new ArrayList<>();
       for(int i=0;i<n;i++){
           if(i!=0){
               list1.add(nums[i]);
           }
           if(i!=n-1){
               list2.add(nums[i]);
           }
       }
       return Math.max(helper(list1),helper(list2));
    }
}



/**class Solution {
        public int rob(int[] nums) {
      if (nums.length == 1) return nums[0];  
      return Math.max(rob0(nums), rob1(nums));
    }
    
    public int rob0(int[] nums){
      int preMax = 0, curMax = 0;
      for(int i = 0; i < nums.length - 1; i++){
        int t = curMax;
        curMax = Math.max(preMax + nums[i], curMax);
        preMax = t;  
      }  
      return curMax;
    }
    
    public int rob1(int[] nums){
      int preMax = 0, curMax = 0;
      for(int i = 1; i < nums.length; i++){
        int t = curMax;
        curMax = Math.max(preMax + nums[i], curMax);
        preMax = t;  
      }  
      return curMax;  
    }
} */
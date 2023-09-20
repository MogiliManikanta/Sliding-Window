class Solution {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      int temp[] = new int[n];
      int k=0;
      temp[k]=nums[0];
      for(int i=1;i<n;i++){
          if(nums[i]<temp[k]){
              int lowerbound=0,upperbound=k;
              while(lowerbound <= upperbound){
                  int mid = (lowerbound + upperbound)/2;
                  if(temp[mid]<nums[i]){
                      lowerbound=mid+1;
                  }
                  else{
                      upperbound=mid-1;
                  }
              }
              temp[lowerbound]=nums[i];
          }
          else if(nums[i]!=temp[k]){
              k++;
              temp[k]=nums[i];
          }
        }
        return k+1;

    }
}
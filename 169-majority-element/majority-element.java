class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0,ele=nums[0],n=nums.length;
        for(int i=0;i<n;i++){
            if(cnt==0){
                ele=nums[i];
                cnt++;
            }
            else if(nums[i]==ele){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele) count++;
        }
        if(count>n/2) return ele;
        return -1;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0],n=nums.length,cnt=0;
        for(int i=0;i<n;i++){
            if(cnt==0){
                ele=nums[i];
                cnt=1;
            }
            else if(nums[i]==ele){
                cnt++;
            }
            else {
                cnt--;
            }
        }
        int cnt2=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==ele) cnt2++;
        }
        if(cnt2>n/2) return ele;
        return -1;
    }
}
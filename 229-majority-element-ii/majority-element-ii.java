class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1=nums[0],ele2=0,count1=0,count2=0,n=nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]==ele1) {
                count1++;
            }
            else if(nums[i]==ele2) {
                count2++;
            }
            else if(count1==0 && nums[i]!=ele2) {
                count1=1;
                ele1=nums[i];
            }
            else if(count2==0 && nums[i]!=ele1) {
                count2=1;
                ele2=nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer>list=new ArrayList<>();
        int cnt1=0,cnt2=0;
        for(int i=0;i<n;i++) {
            if(ele1==nums[i]) {
                cnt1++;
            }
            else if(ele2==nums[i]) {
                cnt2++;
            }
        }
        if(cnt1>n/3) list.add(ele1);
        if(cnt2>n/3) list.add(ele2);
        return list;
    }
}
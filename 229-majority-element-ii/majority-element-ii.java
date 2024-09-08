class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cnt1=0,cnt2=0;
        int ele1=nums[0],ele2=nums[0],n=nums.length;
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1++;
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2++;
            }
            else if(ele1==nums[i]){
                cnt1++;
            }
            else if(ele2==nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        int cnt12=0,cnt22=0;
        int req=(n/3)+(n%3);
        for(int i=0;i<n;i++){
            if(ele1==nums[i]) cnt12++;
            else if(ele2==nums[i]) cnt22++;
        }
        if(cnt12> n/3){
                list.add(ele1);
            }
            if(cnt22>n/3){
                list.add(ele2);
            }
        return list;
    }
}
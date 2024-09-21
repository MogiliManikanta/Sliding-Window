class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>result=new ArrayList<>();
        int cnt1=0,cnt2=0;
        int ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                cnt1++;
            }
            else if(nums[i]==ele2){
                cnt2++;
            }
            else if(cnt1==0 && nums[i]!=ele2){
                cnt1=1;
                ele1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=ele1){
                cnt2=1;
                ele2=nums[i];
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        int cntInd1=0,cntInd2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1) cntInd1++;
            if(nums[i]==ele2) cntInd2++;
        }
        int n=nums.length;
        if(cntInd1>n/3){
            result.add(ele1);
        }
        if(cntInd2>n/3){
            result.add(ele2);
        }
        return result;
    }
}
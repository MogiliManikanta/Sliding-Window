class Solution {    
public  void reverse(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[n - 1 - i];
        arr[n - 1 - i] = temp;
    }
}

    int[] LIS(int[] nums)
    {
        int n=nums.length;
        //vector<int>dp(n,1);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        //vector<int>helper;
        int[] helper = new int[n];
        helper[0]=nums[0];
        int ind=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>helper[ind]) {
                ind++;
                helper[ind]=nums[i];
            }
            else {
                putproper(nums[i],helper,ind);
            }
            dp[i]=ind+1;
        }
        return dp;
    }
    void putproper(int val,int[] arr,int lastind) //binary search to put element at correct position
    {
        int start=0;
        int end=lastind;
        int mid;
        while(start<end)
        {
            mid=start+(end-start)/2;
            if(arr[mid]==val)
                return ;
            else if(arr[mid]>val)
                end=mid;
            else
                start=mid+1;
        }
        arr[start]=val;
        
    }
    int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int[] inc=LIS(arr);
        //reverse(arr.begin(),arr.end());
        reverse(arr);
        int[] dec=LIS(arr);
        //reverse(dec.begin(),dec.end());
        reverse(dec);
        int ans=n;
        for(int i=0;i<n;i++)
        {
            if(inc[i]>1 && dec[i]>1)
                ans=Math.min(ans,n-inc[i]-dec[i]+1);
        }
        return ans;
        
    }
};
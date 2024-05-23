class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n= nums.length;
        int cnt=0;

        int[] fre = new int[1001];
        for (int i = 0; i < (1<<n); i++) {
            int flag=0;
            int lol=0;
            for (int j = 0; j < n; j++) {

                if( (i & (1<<j)) != 0) {
                    fre[nums[j]]++;
                    int x= nums[j] + k;
                    int y= nums[j] - k;
                    lol++;
                    if(x>=1 && x<=1000 && fre[x]>0 ) { flag=1; break; }
                    if(y>=1 && y<=1000 && fre[y]>0) { flag=1; break; }
                }

            }
            if(lol==0 ) continue;
            for (int j = 0; j < n; j++) {
                fre[nums[j]]=0;
            }

            if(flag == 0) cnt++;
        }

        return cnt;
    
        
    }
}
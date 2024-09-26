class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[]{-1,-1,-1};
        int cnt=0;
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1) {
                cnt+=(1 + Math.min(hash[0],Math.min(hash[1],hash[2])));
            }
        }
        return cnt;
    }
}

/*class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length(),cnt=0;
        for(int i=0;i<n;i++) {
            int[] hash = new int[3];
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3) {
                    // cnt+=1; it will also work but passing 34
                    cnt+=n-j;// work tle
                    break;
                }
            }
        }
        return cnt;
    }
}*/
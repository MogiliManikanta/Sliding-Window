class Solution {
    public boolean checkPossibility(String str1 , String str2){
        if(str1.length() != str2.length()+1){
            return false;
        }
        int first=0;
        int second=0;
        while(first<str1.length()){
            if(second < str2.length() && str1.charAt(first)==str2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        if(first==str1.length() && second ==str2.length()){
            return true;
        }
        else {
            return false;
        }
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length() - b.length());
        int n= words.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(checkPossibility(words[i],words[j]) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
}
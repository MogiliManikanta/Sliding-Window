class Solution {
    public boolean validPalindrome(String s) {
        if(s.isEmpty() || s.length()==0){
            return false;
        }
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return palindromeOrNot(s,left+1,right) || palindromeOrNot(s,left,right-1);
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
    public  boolean palindromeOrNot(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
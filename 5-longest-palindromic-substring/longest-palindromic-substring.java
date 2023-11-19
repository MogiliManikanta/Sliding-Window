/*class Solution {
    public String longestPalindrome(String s) {
        
    }
}*/
class Solution{
    boolean Palindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    String longestPalindrome(String S){
        // code here
        String ans = "";
        int maxl = Integer.MIN_VALUE;
        for(int i = 0; i <= S.length() - 1; i++){
            for(int j = i; j <= S.length() - 1; j++){
                String p = S.substring(i,j+1);
                if(Palindrome(p)){
                  if(p.length() > maxl){
                     ans = p;
                     maxl = p.length();
                  }
                }
            }
        }
        return ans;
    }
}

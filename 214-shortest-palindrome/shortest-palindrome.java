class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s+"#"+rev; // use special character to overlap
        int len = temp.length();
        int[] table = new int[len];
        /**
        1.build kmp table
        2.i -> suffix boundary
        3.j - >prefix boundary
         */
        for(int i=1;i<len;i++){
            // update prefix boundary
            int j = table[i-1];
            while(j>0 && temp.charAt(i)!=temp.charAt(j)){
                // move the last prefix boundary match
                j=table[j-1];
            }
            // prefix boundary match suffix boundary,increase prefix length
            if(temp.charAt(i)==temp.charAt(j)){
                table[i] = j+1;
            }
        }
        return rev.substring(0,s.length()-table[len-1])+s;
    }
}
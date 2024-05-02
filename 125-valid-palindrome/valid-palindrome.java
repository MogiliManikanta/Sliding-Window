class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int  headlength = 0, taillength = s.length()-1;
        while(headlength <= taillength){
            char headchar = s.charAt(headlength);
            char tailchar = s.charAt(taillength);
            if(!Character.isLetterOrDigit(headchar)){
                headlength++;
            }
            else if(!Character.isLetterOrDigit(tailchar)){
                taillength--;
            }
            else{
                if(Character.toLowerCase(headchar) != Character.toLowerCase(tailchar)){
                    return false;
                }
                taillength--;
                headlength++;
            }
        }
        return true;
    }
}
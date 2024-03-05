class Solution {
    public int minimumLength(String s) {
        int left=0; // from the leftside of the string
        int right=s.length()-1;  // from the rightside of the string
        while(left<right && s.charAt(left)==s.charAt(right)){
            char temp = s.charAt(left);
            while(left<=right && temp==s.charAt(left)){ // check if the leftchar also matches or not prefix
                left++;
            }
            while(left<=right && temp==s.charAt(right)){ // check if the rightcghar also matches suffix
                right--;
            }
        }
        return right-left+1; //return left-right+1
    }
}
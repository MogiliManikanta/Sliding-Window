class Solution {
    public String addBinary(String a, String b) {
        int i= a.length()-1;
        int j= b.length()-1;
        int sum =0;
        int carry =0;
        StringBuilder result = new StringBuilder();
        while(i>=0 || j>=0 || carry == 1){
            sum = carry;
            if(i>=0){
                sum += a.charAt(i) -'0';
            }
            if(j>=0){
                sum += b.charAt(j) -'0';
            }
            result.append((char) (sum%2 +'0'));
            carry = sum/2;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
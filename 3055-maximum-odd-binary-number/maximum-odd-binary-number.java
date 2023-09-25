class Solution {
    public String maximumOddBinaryNumber(String s) {
        int countZero=0,countOne=0;
        for(char c : s.toCharArray()){
            if(c=='0'){
                countZero++;
            }
            if(c=='1'){
                countOne++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length()-1;i++){
            if(countOne>1){
                sb.append("1");
                countOne--;
            }
            else if(countZero>=1){
                sb.append("0");
                countZero--;
            }
        }
        sb.append("1");
        return sb.toString();
    }
}
class Solution {
    public String largestGoodInteger(String num) {
        String[] arr = {"999", "888", "777", "666", "555", "444", 
                        "333", "222", "111", "000"};
        for(String s : arr){
            if(num.indexOf(s) >= 0){
                return s;
            }
        }
        
        return "";
    }
}
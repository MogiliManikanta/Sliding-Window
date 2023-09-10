class Solution {
    public int minAddToMakeValid(String s) {
       int unMatchedOpen =0;
       int unMatchedClose =0;
       for(char c : s.toCharArray()){
           if(c=='('){
               unMatchedOpen++;
           }
           else if(unMatchedOpen>0){
               unMatchedOpen--;
           }
           else{
               unMatchedClose++;
           }
       }
       return unMatchedOpen+unMatchedClose; 
    }
}
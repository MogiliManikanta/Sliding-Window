class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
       int result=-1;
       for(int i=0;i<s.length();i++){
           int last=s.lastIndexOf(s.charAt(i));
           if(last!=i){
               result=Math.max(result,last-i-1);
           }
       }
       return result; 
    }
}
// class Solution {
//     public int lengthOfLastWord(String s) {
//       int result=0;
//       s=s.trim();
//       for(int i=s.length()-1;i>=0;i--){
//           if(s.charAt(i)!=' '){
//               result++;
//           }
//           else{
//               //if(result>0){
//                   return result;
//               //}
//           }
//       }
//       return result;  
//     }
// }/**   

class Solution {
    public int lengthOfLastWord(String s) {
        String[] chars = s.split("[\\s]+");
        int length = chars[chars.length - 1].length();

        return length;
    }
}
 
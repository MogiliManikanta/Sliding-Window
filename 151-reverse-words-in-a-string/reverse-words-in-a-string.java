class Solution {
    public String reverseWords(String s) {
       s=s.trim();
       s=s.replaceAll("\\s+"," ");
       int i=0,j=0;
       char[] ch = s.toCharArray();
       while(i<=ch.length && j<=ch.length){
           if(j==ch.length || s.charAt(j)==' '){
               reverse(ch,i,j);
               i=j+1;
           }
           j++;
       }
       reverse(ch,0,ch.length);
       return String.valueOf(ch); 
    }
    public void reverse(char[] ch,int left,int right){
        right--;
        while(left<right){
            char temp = ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
    }
}
//s.replaceAll("\\s+"," ");
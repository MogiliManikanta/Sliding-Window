class Solution {
    public String reorganizeString(String s) {
        int[] alphabet=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int c=(ch-'a');
            alphabet[c]++;
        }
//        for(int i=0;i<alphabet.length;i++){
//            System.out.print(alphabet[i]+" ");
//        }
        //finding maxCount
        int letter=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<alphabet.length;i++){
            if(alphabet[i]>max){
                max=alphabet[i];
                letter=i;       //letter=0 for string aabc
            }                   //alphabet=[2,1,1,0-----]
        }
        if(max>(s.length()+1)/2){
            return "";
        }
        //creating new char array in which letters are in organised
        char[] ans=new char[s.length()];
        int ind=0;
        while(alphabet[letter]>0){      //put max count chaacter in even index
            ans[ind]=(char)(letter+'a');
            ind+=2;
            alphabet[letter]--;
        }
        //now put other characters ,
        for(int i=0;i<alphabet.length;i++){
            while(alphabet[i]>0){
                if(ind>=s.length()){
                    ind=1;
                }
                ans[ind]=(char)(i+'a');
                ind+=2;

                alphabet[i]--;
            }
        }
return String.valueOf(ans);
    }
}
class Solution {
    public boolean closeStrings(String word1, String word2) {
       int arr1[] = new int[26];
        int arr2[] = new int[26];
        for(int i=0;i< word1.length();i++){
            arr1[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();i++){
            arr2[word2.charAt(i)-'a']++;
        }


        if(word1.length()!=word2.length()){
            return false;
        }
        for(int i=0;i<26;i++){
            if(arr1[i]==arr2[i]){
                continue;
            }
            if(arr1[i]==0 || arr2[i]==0){ 
                return false;
            }
            /** 
            
                word1 == aabca 
                freq1[]  0  1  2  3  4
                         3  1  1

                word2 == aabda

                freq2[]  0  1  2  3  4
                         3  1  0  1


                whenever the one frequency is zero and other is something else then the result is false 
            
            
            
            
            */

        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
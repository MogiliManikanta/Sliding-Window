class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;//storing the frequency
        }
        int start=0,end=0,minLength=Integer.MAX_VALUE,counter=t.length(),minStart=0;
        while(end<s.length()){
            char endChar = s.charAt(end);
            if(freq[endChar]>0){
                counter--;//if word matches in the both the string decrement the counter variable
            }
            freq[endChar]--;//decrementing the counter variable
            end++;//incrementhing the end variable
            while(counter==0){//if all the matches then counter variable set to 0
                if(minLength>end-start){
                    minLength=end-start;//taking the minlength
                    minStart=start;//minimum start
                }
                char startChar = s.charAt(start);//again iterate the from the start character 
                freq[startChar]++;
                if(freq[startChar]>0){// if the frequency is greater than zero increment the counter 0
                    counter++;
                }
                start++;// increment the start operator
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minLength+minStart);// if no string not found return the empty and the return the substring
    }
}
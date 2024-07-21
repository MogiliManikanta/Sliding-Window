class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        String result[] = new String[numRows];
        for(int i=0;i<result.length;i++){
            result[i]="";
        }
        boolean flag=false;
        int i=0;
        char[] str = s.toCharArray();
        for(char c : str){
            result[i]+=c;
            if(i==0 || i==numRows-1){
                flag=!flag;
            }
            if(flag){
                i+=1;
            }
            else{ 
                i-=1;
            }
        }
        String answer="";
        for(int j=0;j<result.length;j++){
            answer+=result[j];
        }
        return answer;
    }
}
class Solution {
    public int numDecodings(String s) {
                int len = s.length();
        int[] num = new int[len];
        if (s.charAt(0) == '0') return 0;
        if (len == 1) return 1;
        boolean handleIndex2Is0Case = s.charAt(0) == '1' || s.charAt(0) == '2';
        if (len == 2){
            if (s.charAt(1) == '0'){
                if (handleIndex2Is0Case) return 1;
                else return 0;
            }else {
                if (Integer.parseInt(s) <= 26 ) return 2;
                else return 1;
            }
        }
        num[0] = 1;
        if (s.charAt(1) == '0'){
            if (handleIndex2Is0Case) num[1] = 1;
            else num[1] = 0;
        }else {
            if (Integer.parseInt(s.substring(0, 2)) <= 26 ) num[1] = 2;
            else num[1] = 1;
        }


        for (int i = 2; i < len; i ++){
            if (s.charAt(i) != '0')
                num[i] = num[i-1];
            if (s.charAt(i-1) != '0' && Integer.parseInt(s.substring(i-1, i+1)) <= 26) num[i] += num[i-2];
        }

        return num[len-1];
    }
}
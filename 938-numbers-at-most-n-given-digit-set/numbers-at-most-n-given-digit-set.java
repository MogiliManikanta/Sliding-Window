class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        if (D == null || D.length == 0 || N == 0) return 0;
        String nStr = Integer.toString(N);
        int numDigitsN = nStr.length();
        int total = 0;
        int numDigits = D.length;

        // if N = 2563, D = {1,2,6}
        // x, xx, xxx for each digit: 3^1 + 3^2 + 3^3;
        for (int i = 1; i < numDigitsN; i++) {
            total += Math.pow(numDigits, i);
        }
        
        // xxxx from left most digit (max = 3^4 -1, if N = 9999)
        // (1<2) count of 1xxx is 3^3
        // (2==2) hasSameNum = true
        // then out of the inner for loop
        // then i = 1, so (hasSameTrue = false)
        // (1<5) count of 21xx = 3^4-1-1 = 3^2
        // (2<5) count of 22xx = 3^4-1-1 = 3^2
        // return total
        for (int i = 0; i < numDigitsN; i++) {
            boolean hasSameNum = false;
            for (String d : D) {
                if (d.charAt(0) < nStr.charAt(i)) {
                    total += Math.pow(numDigits, numDigitsN -i-1);
                } else if (d.charAt(0) == nStr.charAt(i)) {
                    hasSameNum = true;
                }
            }
            if (!hasSameNum) return total;
        }
        //
        return total+1;
    }
}
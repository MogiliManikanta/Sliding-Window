class Solution {
    public int minOperations(int[] array, int target) {
        int xorRes = 0,index = 0,setBits = 0;;
        while (index < array.length) {
            xorRes = xorRes ^ array[index];
            index++;
        }
        int modXOR = target^xorRes;
        boolean flag =true;
        while (modXOR != 0 && flag) {
    setBits = setBits + (1 & modXOR);
    modXOR = 1+(modXOR >> 1)-1;
}
        return setBits;
    }
}


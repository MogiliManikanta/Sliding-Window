class Solution {
    public long wonderfulSubstrings(String word) {
       int[] count = new int[1024]; // according to the constraint the length is 10^5
       long result=0; // to store the result
       count[0]=1; // initially the count is 1
       int mask=0; // to do the mask operation
       for(char c : word.toCharArray()){
           mask^=1<<(c-'a'); // for even count of characters
           result+=count[mask];
           for(int i=0;i<10;i++){ // according the constraint the alphabets be a to j
               result+=count[mask^(1<<i)]; // count the odd length of characters
           }
           count[mask]++; //increasing the count the frequency
       }
       return result;  // return the result
    }
}

/**

"<<" means left shift the bits of a value.
">>" means right shift the bits of a value.

example:
int a = 5; //the binary value of 5 is 101
a = a << 3; //left shift 3 bits on 101, 101 000<< add 3 bits(0) on the right, become '101000'
System.out.println(a); //this will display 40, the decimal for '101000'

int b = 9; //the binary value of 8 is 1001
b = b >> 3; //right shift 3 bits on >>000 1001 add 3 bits(0) on the left, truncate the last 3 bits on the right become '001'
System.out.println(b); //this will display 1, the decimal for '001'
 */
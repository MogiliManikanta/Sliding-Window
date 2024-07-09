class Solution {
    public int singleNumber(int[] A) {
         int result = 0;
    for (int i = 0; i<A.length; i++)
    {
		result ^=A[i];
    }
	return result;
    }
}
/**Similarly , if we observe ,

A^A=0
A^B^A=B
(A^A^B) = (B^A^A) = (A^B^A) = B This shows that position doesn't matter.
Similarly , if we see , a^a^a^a......... (even times)=0 and a^a^a........(odd times)=a


 */
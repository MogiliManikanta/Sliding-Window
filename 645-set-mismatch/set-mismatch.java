import java.util.*;
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actualSum = 0;
        int uniqueSum = 0;
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            actualSum += num;
            numSet.add(num);
        }
        
        for (int num : numSet) {
            uniqueSum += num;
        }
        
        int expectedSum = n * (n + 1) / 2;
        
        int duplicate = actualSum - uniqueSum;
        int missing = expectedSum - uniqueSum;
        
        return new int[]{duplicate, missing};
    }
}

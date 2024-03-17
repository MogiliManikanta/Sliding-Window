class Solution {
    public double[] sampleStats(int[] count) {
        int left = 0, right = 255, leftCount = 0, rightCount = 0, min = 256, max = -1, mid1 = 0, mid2 = 0, modeValue = 0;
        double average = 0, median = 0;
        
        while (left <= right) {
            while (count[left] == 0) left++;
            while (count[right] == 0) right--;
            
            if (leftCount < rightCount) {
                average += (double) count[left] * left;
                leftCount += count[left];
                if (count[left] > count[modeValue]) modeValue = left;
                max = Math.max(max, left);
                min = Math.min(min, left);
                mid1 = left;
                left++;
            } else {
                average += (double) count[right] * right;
                rightCount += count[right];
                if (count[right] > count[modeValue]) modeValue = right;
                max = Math.max(max, right);
                min = Math.min(min, right);
                mid2 = right;
                right--;
            }
        }
        
        average /= (leftCount + rightCount);
        
        // Find median
        if (leftCount < rightCount) median = mid2;
        else if (leftCount > rightCount) median = mid1;
        else median = (double) (mid1 + mid2) / 2;
        
        return new double[]{min, max, average, median, modeValue};
    }
}

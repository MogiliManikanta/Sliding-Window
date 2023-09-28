/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray A) {
        int arrayLength = A.length();
int leftIndex, rightIndex, midIndex, peakIndex = 0;

// Find the index of the peak element in the array.
leftIndex = 0;
rightIndex = arrayLength - 1;
while (leftIndex < rightIndex) {
    midIndex = (leftIndex + rightIndex) / 2;
    if (A.get(midIndex) < A.get(midIndex + 1))
        leftIndex = peakIndex = midIndex + 1;
    else
        rightIndex = midIndex;
}

// Find the target value on the left side of the peak.
leftIndex = 0;
rightIndex = peakIndex;
while (leftIndex <= rightIndex) {
    midIndex = (leftIndex + rightIndex) / 2;
    if (A.get(midIndex) < target)
        leftIndex = midIndex + 1;
    else if (A.get(midIndex) > target)
        rightIndex = midIndex - 1;
    else
        return midIndex;
}

// Find the target value on the right side of the peak.
leftIndex = peakIndex;
rightIndex = arrayLength - 1;
while (leftIndex <= rightIndex) {
    midIndex = (leftIndex + rightIndex) / 2;
    if (A.get(midIndex) > target)
        leftIndex = midIndex + 1;
    else if (A.get(midIndex) < target)
        rightIndex = midIndex - 1;
    else
        return midIndex;
}

// If the target is not found in the array, return -1.
return -1;
    }
}
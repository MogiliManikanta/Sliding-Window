import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public  void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Already sorted or empty array
        }

        int n = array.length;
        int[] temp = new int[n];
        mergeSortHelper(array, temp, 0, n - 1);
    }

    private void mergeSortHelper(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the left and right halves
            mergeSortHelper(array, temp, left, mid);
            mergeSortHelper(array, temp, mid + 1, right);

            // Merge the sorted halves
            merge(array, temp, left, mid, right);
        }
    }

    private  void merge(int[] array, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = temp[i];
            k++;
            i++;
        }
    }

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n % 3 != 0) return new int[0][]; // Not a multiple of 3, impossible
        mergeSort(nums);
        List<int[]> result = new ArrayList<>();
        int i=0;
        while(i < n) {
            if (!(i + 2 < n && nums[i + 2] - nums[i] <= k)) {
                result.clear(); // Clear any partially formed subarrays
                break; // Break the loop immediately on an invalid subarray
            } else {
                result.add(new int[]{nums[i], nums[i + 1], nums[i + 2]});
            }
            i+=3;
        }

        return result.toArray(new int[0][]);
    }
}

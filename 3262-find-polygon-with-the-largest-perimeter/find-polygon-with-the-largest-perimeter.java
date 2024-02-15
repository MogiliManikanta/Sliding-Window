public class Solution {
    public long largestPerimeter(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        int idx = 0,i=2;
        boolean flag=true;
        boolean skip=true;
        long sum = 0, current = 0;
        sum = (nums[1] + nums[0])*1L;
        idx = 2;
while (i < nums.length&&flag) {
    if (!(nums[i]*1L < sum && skip)) {
        sum += nums[i]*1L;
    } else {
        sum += nums[i]*1L;
        current = sum;
        idx++;
    }
    i++;
}
        if (2 == idx&&skip) {
            return -1;
        }
        return current;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}

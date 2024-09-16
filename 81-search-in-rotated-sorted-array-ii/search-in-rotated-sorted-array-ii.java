class Solution {
    public boolean search(int[] arr, int target) {
       int low = 0, high = arr.length - 1; //<---step 1

        while (low <= high) { //<--- step 2
            int mid = (low + high) / 2; //<----step 3
            if (arr[mid] == target)
                return true; // <---step 4
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){ //only difference is here only
                low++;
                high--;
                continue;
            }
            if (arr[low] <= arr[mid]) { //<---step 5
                if (arr[low] <= target && arr[mid] >= target)
                    high = mid - 1; //<---step 6 
                else
                    low = mid + 1; //<---step 7
            } else { //<---step 7
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false; //<---step 8 
    }
}

// class Solution {
//     public int search(int[] nums, int target) {
//         int low=0;
//         int high=nums.length-1;
//         while(low<=high){
//             int mid = low+(high-low)/2;
//             if(nums[mid]==target){
//                 return mid;
//             }
//             else if(nums[low]<=nums[mid]){
//                 if(nums[low]<=target && nums[mid]>=target){
//                     high=mid-1;
//                 }
//                 else{
//                     low=mid+1;
//                 }
//             }
//             else{
//                 if(nums[high]>=target && nums[mid]<=target){
//                     low=mid+1;
//                 }
//                 else{
//                     high=mid-1;
//                 }
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int search(int[] arr, int target) {
       int low = 0, high = arr.length - 1; //<---step 1

        while (low <= high) { //<--- step 2
            int mid = (low + high) / 2; //<----step 3
            if (arr[mid] == target)
                return mid; // <---step 4
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
        return -1; //<---step 8 
    }
}
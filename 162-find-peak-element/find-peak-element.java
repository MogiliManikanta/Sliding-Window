/*class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(high-low>1){
            int mid=(low+(high-low)/2);
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return (low==n-1 || nums[low]>nums[low+1]) ? low : high;
    }
    /**I can write out the solution using binary search and get accepted.
But I cannot understand how it works and why using binary searching on unsorted array is reasonable in this problem.
Can anyone please help to explain this problem in details? Thanks a lot! */
    /**Most people have figured out the binary search solution but are not able to understand how its working. I will try to explain it simply. What we are essentially doing is going in the direction of the rising slope(by choosing the element which is greater than current). How does that guarantee the result? Think about it, there are 2 possibilities.a) rising slope has to keep rising till end of the array b) rising slope will encounter a lesser element and go down.
In both scenarios we will have an answer. In a) the answer is the end element because we take the boundary as -INFINITY b) the answer is the largest element before the slope falls. Hope this makes things clearer. *
    public int findPeakElement(int[] num) {
        int low = 0;
        int high = num.length-1;
        
        while(low < high)
        {
            int mid1 = low+(high-low)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    } 
}*/
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length; // Size of array

        // Edge cases:
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If nums[mid] is the peak:
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;

            // If we are in the left:
            if (nums[mid] > nums[mid - 1]) low = mid + 1;

            // If we are in the right:
            // Or, nums[mid] is a common point:
            else high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }
}
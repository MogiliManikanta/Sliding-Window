// public class Solution {
//     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//         // Check if k is less than 1 or t is less than 0, return false if either condition is met.
//         if (k < 1 || t < 0) return false;
        
//         // Create a HashMap to store buckets of numbers with their corresponding values.
//         Map<Long, Long> map = new HashMap<>();
        
//         // Loop through the input array 'nums'.
//         for (int i = 0; i < nums.length; i++) {
//             // Calculate a remapped value for the current number to handle negative numbers.
//             long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            
//             // Determine the bucket this remapped number falls into.
//             long bucket = remappedNum / ((long) t + 1);
            
//             // Check if the current bucket or adjacent buckets contain values within the 't' difference.
//             if (map.containsKey(bucket)
//                     || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
//                     || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
//                 return true; // If any of the conditions are met, return true.
//             }
            
//             // If the size of the map exceeds 'k', remove the oldest bucket to maintain the window of size 'k'.
//             if (map.entrySet().size() >= k) {
//                 long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
//                 map.remove(lastBucket);
//             }
            
//             // Put the current bucket and its remapped value in the map.
//             map.put(bucket, remappedNum);
//         }
        
//         return false; // If no pair of numbers satisfying the conditions is found, return false.
//     }
// }

/*class Solution{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){ // O(n)
            Long el = new Long(nums[i]);
            Long floor = set.floor(el); //next lower value O(log k) in treeset

            Long ceil = set.ceiling(el); // next higher value O(log k) in treeset
            if(floor!=null && Math.abs(floor-el)<=t){
                return true;
            }
            if(ceil!=null && Math.abs(ceil-el)<=t){
                return true;
            }
            set.add(el);
            if(set.size()>k){ // size of set is always k and hence becomes a sliding window problem
                set.remove(new Long(nums[i-k]));
            }

        }
        return false;
    }
}*/
/**
 * Sliding Window solution using Buckets
 *
 * Time Complexity: O(N)
 *
 * Space Complexity: O(min(N, K+1))
 *
 * N = Length of input array. K = Input difference between indexes.
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }

        HashMap<Long, Long> buckets = new HashMap<>();
        // The bucket size is t+1 as the ranges are from 0..t, t+1..2t+1, ..
        long bucketSize = (long) t + 1;

        for (int i = 0; i < nums.length; i++) {
            // Making sure only K buckets exists in map.
            if (i > k) {
                long lastBucket = ((long) nums[i - k - 1] - Integer.MIN_VALUE) / bucketSize;
                buckets.remove(lastBucket);
            }

            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / bucketSize;

            // If 2 numbers belong to same bucket
            if (buckets.containsKey(bucket)) {
                return true;
            }

            // If numbers are in adjacent buckets and the difference between them is at most
            // t.
            if (buckets.containsKey(bucket - 1) && remappedNum - buckets.get(bucket - 1) <= t) {
                return true;
            }
            if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - remappedNum <= t) {
                return true;
            }

            buckets.put(bucket, remappedNum);
        }

        return false;
    }
}
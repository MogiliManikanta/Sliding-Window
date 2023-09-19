import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create a HashMap to store the frequency of elements in nums1
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Create an ArrayList to store the common elements
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // Populate the HashMap with elements from nums1 and their frequencies
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                // If the element is already in the HashMap, increment its frequency
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                // If the element is not in the HashMap, add it with a frequency of 1
                map.put(nums1[i], 1);
            }
        }
    
        // Check for common elements with nums2 and update the result and HashMap
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                // If the element is in the HashMap and its frequency is greater than 0,
                // add it to the result list and decrement its frequency in the HashMap
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
    
        // Convert the ArrayList to an int array
        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        
        // Return the final result as an int array containing common elements
        return r;
    }
}
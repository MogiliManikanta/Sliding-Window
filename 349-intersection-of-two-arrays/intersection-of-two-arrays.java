class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create a HashSet to store unique elements from nums1
        HashSet<Integer> set1 = new HashSet<>();
        
        // Iterate through nums1 and add each element to set1
        for (int i : nums1) {
            set1.add(i);
        }
        
        // Create another HashSet to store common elements between nums1 and nums2
        HashSet<Integer> set2 = new HashSet<>();
        
        // Iterate through nums2
        for (int i : nums2) {
            // If the element 'i' exists in set1, it's a common element, so add it to set2
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        
        // Create an array to store the intersection elements
        int[] result = new int[set2.size()];
        int index = 0;
        
        // Iterate through set2 to fill the result array
        for (Integer i : set2) {
            result[index++] = i;
        }
        
        // Return the array containing the intersection of nums1 and nums2
        return result;
    }
}
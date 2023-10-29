class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Check if the input array is empty. If it is, return an empty list.
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a HashMap to store the anagram groups.
        // The key will be a sorted version of each word, and the value will be a list of anagrams.
        HashMap<String, List> ans = new HashMap<>();

        // Iterate through the input array of strings.
        for (String s : strs) {
            // Convert the current string to a character array.
            char[] array = s.toCharArray();

            // Sort the character array in alphabetical order.
            Arrays.sort(array);

            // Convert the sorted character array back to a string.
            String sorted = String.valueOf(array);

            // Check if the sorted string is not already in the HashMap.
            if (!(ans.containsKey(sorted))) {
                // If not, create a new list for that sorted string and put it in the HashMap.
                ans.put(sorted, new ArrayList<>());
            }

            // Add the original string to the list corresponding to the sorted string in the HashMap.
            ans.get(sorted).add(s);
        }

        // Create a new ArrayList to store the final result, which will be the values (lists of anagrams) in the HashMap.
        return new ArrayList(ans.values());
    }
}

class Solution{
public static List<Integer> findSubstring(String S, String[] L) {
    List<Integer> res = new ArrayList<Integer>(); // Create a list to store the results.
    
    // Check for edge cases.
    if (S == null || L == null || L.length == 0) return res;

    int len = L[0].length(); // Get the length of each word in L.

    // Create a map to store the frequency of each word in L.
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (String w : L) {
        // If the word is already in the map, increment its count; otherwise, add it with a count of 1.
        map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
    }

    // Iterate through S from index 0 to a point where there are enough characters left for L.
    for (int i = 0; i <= S.length() - len * L.length; i++) {
        // Create a copy of the map for each iteration to avoid modifying the original map.
        Map<String, Integer> copy = new HashMap<String, Integer>(map);

        // Check if the current substring of S starting at index 'i' can form a valid concatenation.
        for (int j = 0; j < L.length; j++) {
            // Extract the next word from S.
            String str = S.substring(i + j * len, i + j * len + len);

            // Check if the word is in the copy of the map.
            if (copy.containsKey(str)) {
                int count = copy.get(str);

                if (count == 1) {
                    copy.remove(str); // If there's only one instance of the word, remove it from the copy.
                } else {
                    copy.put(str, count - 1); // Otherwise, decrement its count in the copy.
                }

                if (copy.isEmpty()) {
                    // If the copy becomes empty, it means all words in L have been matched, so add the index 'i' to the result.
                    res.add(i);
                    break;
                }
            } else {
                // If the current word is not in L, break out of the loop.
                break;
            }
        }
    }

    return res; // Return the list of starting indices where valid concatenations were found.
}
}
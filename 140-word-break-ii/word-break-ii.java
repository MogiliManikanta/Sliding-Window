class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {  
        // Create a HashMap to store intermediate results for memoization
        HashMap<Integer, List<String>> hm = new HashMap<>(); 
        // Create a HashSet for faster word lookup
        HashSet<String> hs = new HashSet<>(wordDict);        
        // Call the helper function with initial parameters and return its result
        return wordBreakHelper(s, 0, hs, hm);
    }
    private List<String> wordBreakHelper(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> hm) {
        // If this starting index has already been processed, return its result
        if (hm.containsKey(start))
            return hm.get(start);
        // List to store valid substrings from this starting index
        List<String> validSubstr = new ArrayList<>();
        // If we have reached the end of the string, add an empty string as a valid substring
        if (start == s.length())
            validSubstr.add("");
        // Iterate over possible end indices to form substrings
        for (int end = start + 1; end <= s.length(); end++) {
            // Extract the current substring from start to end
            String prefix = s.substring(start, end);  
            // If the current substring is in the dictionary
            if (dict.contains(prefix)) {
                // Recursively find valid substrings for the remaining part of the string
                List<String> suffixes = wordBreakHelper(s, end, dict, hm);       
                // Combine the current prefix with each valid suffix
                for (String suffix : suffixes)
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix); 
            }
        }
        // Store the valid substrings for this starting index in the memoization HashMap
        hm.put(start, validSubstr);
        // Return the valid substrings for this starting index
        return validSubstr;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        // Check if the string is empty. If so, return 0.
        if(s.length()==0){
            return 0;
        }
        // If the length of the string is less than or equal to k, we can change all characters to the same character and get the length of the string as the result.
        if(s.length()<=k){
            return s.length();
         }
        // Create a HashMap to store the count of characters in the current window.
        HashMap<Character,Integer>map = new HashMap<>();
        // Initialize variables: left pointer, result (maximum length of substring with repeating characters), and maxCount (maximum count of repeating characters in any window).
        int left=0,result=0;
        int maxCount=0;
        // Iterate through the string with a sliding window technique.
        for(int right=0;right<s.length();right++){
            // Update the count of the current character in the map.
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            // Update maxCount to keep track of the maximum count of any character in the current window.
            maxCount = Math.max(maxCount,map.get(s.charAt(right)));
            // If the length of the window minus the maxCount exceeds the allowed number of replacements (k), move the left pointer to shrink the window.
            while(right-left+1-k>maxCount){
                // Decrement the count of the character at the left pointer.
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                // Move the left pointer to the right.
                left++;
            }
            // Update the result with the maximum length of the current valid substring.
            result=Math.max(result,right-left+1);
        }
        // Return the final result.
        return result;
    }
}

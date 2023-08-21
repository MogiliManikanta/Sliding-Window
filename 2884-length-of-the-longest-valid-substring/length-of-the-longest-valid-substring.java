/* Approach : Sliding Window
1. Store all forbidden words in unordered set.
2. Use sliding window to find max length of valid substring
Time : O(m * maxLen + n * (maxLen^2))       // set + Sliding Window         
Space : O(m * maxLen + n * maxLen )         // set + temp string
where, n = word.size(), m = forbidden.size(), maxLen = Max length of any forbidden word
*/
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String>set = new HashSet<>();
        int maxLenForbidden = Integer.MIN_VALUE;
        // store forbidden words in set
        for(String temp : forbidden){
            set.add(temp);
            maxLenForbidden = Math.max(maxLenForbidden,temp.length());
        }
        int left=0,right=0;
        int longest=Integer.MIN_VALUE;
        // sliding window
        while(right<word.length()){
            // check for forbidden substrings after including l in current window
            String temp="";
            for(int i=right;i>=left && i>(right-maxLenForbidden);i--){// need to check only upto maxLen
                temp=word.charAt(i)+temp;
                if(set.contains(temp)){// temp present in forbidden words
                    left=i+1;// ith char can't be present in valid window, update 
                    break;
                }
            }
            right++;// slide right boundary for next iteration
            longest=Math.max(longest,right-left);// update ans for current window
        }
        return longest;
    }
}

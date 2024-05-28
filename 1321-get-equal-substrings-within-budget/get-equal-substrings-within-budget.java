class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start=0;
        int end=0;
        int currentSum = 0;
        while(end<s.length()){
            currentSum += Math.abs(s.charAt(end) - t.charAt(end));
            if(currentSum>maxCost){
                currentSum -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            end++;
        }
        return end-start;
    }
}
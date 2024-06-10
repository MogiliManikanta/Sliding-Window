class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for(int ele : heights){
            freq[ele]++;
        }
        int currentHeight=0;
        int result=0;
        for(int i=0;i<heights.length;i++){
            while(freq[currentHeight]==0){
                currentHeight++;
            }
            if(currentHeight != heights[i]){
                result++;
            }
            freq[currentHeight]--;
        }
        return result;
    }
}
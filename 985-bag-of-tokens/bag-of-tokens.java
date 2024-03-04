class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens); // array should be sorted
        int score=0; // to find the maximum score
        int points=0; // to find the points
        int left=0,right=tokens.length-1; // Two pointers technique
        while(left<=right){
            if(power>=tokens[left]){ //If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
                power-=tokens[left];
                points++;
                score=Math.max(score,points);
                left++;
            }
            else if(points!=0){ //If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
                points--;
                power+=tokens[right];
                right--;
            }
            else{
                break;
            }
        }
        return score;
    }
}
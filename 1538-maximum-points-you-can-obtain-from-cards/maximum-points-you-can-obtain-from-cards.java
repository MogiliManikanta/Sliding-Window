class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,rightSum=0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        int left=k-1,right=cardPoints.length-1;
        int sum=leftSum;
        while(left>=0){
            leftSum-=cardPoints[left];
            rightSum+=cardPoints[right];
            left--;
            right--;
            sum=Math.max(sum,leftSum+rightSum);
        }
        return sum;
    }
}
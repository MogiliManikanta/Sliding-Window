class Solution {
    public int[] findPeakGrid(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            int maxElementInColumnRowIndex = findMax(matrix,mid);
            int leftElement = (mid-1>=0)?matrix[maxElementInColumnRowIndex][mid-1]:-1;
            int rightElement = (mid+1<m)?matrix[maxElementInColumnRowIndex][mid+1]:-1;
            if(matrix[maxElementInColumnRowIndex][mid]>leftElement && matrix[maxElementInColumnRowIndex][mid]>rightElement){
                return new int[]{maxElementInColumnRowIndex,mid};
            }
            else if(matrix[maxElementInColumnRowIndex][mid]<rightElement){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    public int findMax(int[][] matrix,int column){
        int maxi=Integer.MIN_VALUE,index=-1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][column]>maxi){
                maxi=matrix[i][column];
                index=i;
            }
        }
        return index;
    }
}
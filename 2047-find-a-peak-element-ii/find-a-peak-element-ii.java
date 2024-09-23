/*class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
    }
}*/
public class Solution {

    public int findMaxelement(int[][]mat , int n , int m , int col){

        int maxValue=-1;

        int index=-1;

 

        for(int i=0 ; i<n ; i++){

            if(mat[i][col]>maxValue){

                maxValue=mat[i][col];

                index=i;

            }

        }

        return index;

    }

    public  int[] findPeakGrid(int [][]G){

        // Write your code here.

        int n=G.length;

        int m=G[0].length;

 

        int low=0 , high=m-1;

        while(low<=high){

            int mid=(low+high)/2;

            int rowMax=findMaxelement(G, n, m, mid);

            int left=0<=mid-1?G[rowMax][mid-1]:-1;

            int right=mid+1<m?G[rowMax][mid+1]:-1;

 

            if(G[rowMax][mid]>left && G[rowMax][mid]>right){

                return new int[] {rowMax , mid};

            }

            else if(G[rowMax][mid]<left)   high=mid-1;

            else low=mid+1;

        }

        return new int[]{-1 , -1};

 

    }

}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin =0;
        int columnBegin=0;
        int rowEnd=matrix.length-1;
        int columnEnd = matrix[0].length-1;
        int dir=0;
        ArrayList<Integer> result=new ArrayList<>();
        while(rowBegin<=rowEnd && columnBegin<=columnEnd){
            if(dir==0){
                for(int i=columnBegin;i<=columnEnd;i++){
                    result.add(matrix[rowBegin][i]);
                }
                rowBegin++;
            }
            else if(dir==1){
                for(int i=rowBegin;i<=rowEnd;i++){
                    result.add(matrix[i][columnEnd]);
                }
                columnEnd--;
            }
            else if(dir==2){
                for(int i=columnEnd;i>=columnBegin;i--){
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            else{
                for(int i=rowEnd;i>=rowBegin;i--){
                    result.add(matrix[i][columnBegin]);
                }
                columnBegin++;
            }
            dir=(dir+1)%4;
        }
        return result;
    }
}
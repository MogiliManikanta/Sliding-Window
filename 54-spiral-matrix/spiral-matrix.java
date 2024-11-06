class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin =0;
        int rowEnd =matrix.length-1;
        int colBegin=0;
        int colEnd = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        int dir=0;
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            if(dir==0){
                for(int i=colBegin;i <= colEnd;i++){
                    list.add(matrix[rowBegin][i]);
                }
                rowBegin++;
            }
            else if(dir==1){
                for(int i=rowBegin;i <= rowEnd;i++){
                    list.add(matrix[i][colEnd]);
                }
                colEnd--;
            }
            else if(dir==2){
                for(int i=colEnd;i>=colBegin;i--){
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            else{
                for(int i=rowEnd;i>=rowBegin;i--){
                    list.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
            dir=(dir+1)%4;
        }
        return list;
    }
}
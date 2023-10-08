class Solution {
    public  boolean search( char[][] board,String word,int i,int j,int idx){
        if(idx==word.length()-1){
            return true;
        }
        board[i][j]-=65;
        if(i>0 && board[i-1][j]==word.charAt(idx+1) && search(board,word,i-1,j,idx+1)){
            return true;
        }
        if(j>0 && board[i][j-1]==word.charAt(idx+1)&& search(board,word,i,j-1,idx+1)){
            return true;
        }
        if(i<board.length-1 && board[i+1][j]==word.charAt(idx+1) && search(board,word,i+1,j,idx+1)){
            return true;
        }
        if(j<board[0].length-1 && board[i][j+1]==word.charAt(idx+1) && search(board,word,i,j+1,idx+1)){
            return true;
        }
        board[i][j]+=65;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        int idx=0;
       for(int i=0;i<row;i++){
           for(int j=0;j<column;j++){
               if(board[i][j]==word.charAt(0) && search(board,word,i,j,idx)){
                   return true;
               }
           }
       }
       return false; 
    }
}
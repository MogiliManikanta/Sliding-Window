class Solution {
    public boolean isValidIndex(int[][] board,int i,int j){
        return (i>=0 && i<board.length && j>=0 && j<board[0].length);
    }
    public void gameOfLife(int[][] board) {
        int dx[] = {0,0,1,1,1,-1,-1,-1};
        int dy[] = {1,-1,1,-1,0,0,1,-1};
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                int current_Live_Neighbour = 0;
                for(int i=0;i<8;i++){
                    int current_Index_X = row+dx[i];
                    int current_Index_Y = col+dy[i];
                    if(isValidIndex(board,current_Index_X,current_Index_Y) && Math.abs(board[current_Index_X][current_Index_Y])==1){
                        current_Live_Neighbour++;
                    }
                }
                if(board[row][col]==1 && (current_Live_Neighbour < 2 || current_Live_Neighbour>3)){
                    board[row][col]=-1;
                }
                if(board[row][col]==0 && current_Live_Neighbour==3){
                    board[row][col]=2;
                } 
            }
        }
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]>=1){
                    board[row][col]=1;
                }
                else{
                    board[row][col]=0;
                }
            }
        }
    }
}
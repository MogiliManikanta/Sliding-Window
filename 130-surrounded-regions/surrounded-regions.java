class Solution {
    public void solve(char[][] board) {

        if(board==null || board.length==0){
            return;
        }
        int row = board.length;
        int col = board[0].length;

        // first column and lastcolumn
        for(int i=0;i<row;i++){
            if(board[i][0]=='O'){
                dfs(i,1,board);
            }
            if(board[i][col-1]=='O'){
                dfs(i,col-2,board);
            }
        }

        //first row and last row
        for(int i=0;i<col;i++){
            if(board[0][i]=='O'){
                dfs(1,i,board);
            }
            if(board[row-1][i]=='O'){
                dfs(row-2,i,board);
            }
        }
         // flip O to X, '*' to 'O',
        // skip the boulders 
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board){
        if(i<=0 || j<=0 || i>=board.length-1 || j>=board[0].length-1 || board[i][j]=='X'){
            return;
        }
        if(board[i][j]=='*'){
            return;
        }
        if(board[i][j]=='O'){
            board[i][j]='*';
        }
        // move all the four adjacents
        dfs(i,j+1,board);
        dfs(i,j-1,board);
        dfs(i+1,j,board);
        dfs(i-1,j,board);
    }
}
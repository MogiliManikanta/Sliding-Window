class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean check = true;
        //checking all the rows are valid
        for(int i=0;i<9;i++){
            check = isValidRow(board,i);
            if(check==false) return false;
        }
        //check all the colomns are valid
        for(int i=0;i<9;i++){
            check = isValidColomn(board,i);
            if(check==false) return false;
        }
        //check all the boxes are valid
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                check = isValidBox(board,i,j);
                if(check==false) return false;
            }

        }
        return true;
    }
    public boolean isValidRow(char[][] board, int r){
        HashSet<Character> c = new HashSet<Character>();
        for(int i=0;i<9;i++){
            char ch = board[r][i];
            if(ch=='.'){
                continue;
            }else{
                if(c.contains(ch)){
                    return false;
                }else{
                    c.add(ch);
                }
            }   
        }
        return true;
    }
    public boolean isValidColomn(char[][] board, int r){
        HashSet<Character> c = new HashSet<Character>();
        for(int i=0;i<9;i++){
            char ch = board[i][r];
            if(ch=='.'){
                continue;
            }else{
                if(c.contains(ch)){
                    return false;
                }else{
                    c.add(ch);
                }
            }   
        }
        return true;
    }
    public boolean isValidBox(char[][] board, int sr,int sc){
        HashSet<Character> c = new HashSet<Character>();
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                char ch = board[i][j];
                if(ch=='.'){
                    continue;
                }else{
                    if(c.contains(ch)){
                        return false;
                    }else{
                        c.add(ch);
                    }
                }
            }    
        }
        return true;
    } 
}
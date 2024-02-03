class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

       


        //check row whether it contains same number twice
        for(int i = 0; i < n; i++){
            HashSet<Character>rowset = new HashSet();
            for(int j = 0 ; j < m; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(rowset.contains(board[i][j])){
                    return false;
                }

                rowset.add(board[i][j]);
            }
        }

        //check column whether it contains same number twice
        for(int i  = 0; i < m; i++){
            HashSet<Character>colset = new HashSet();
            for(int j = 0; j < n ; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                if(colset.contains(board[j][i])){
                    return false;
                }

                colset.add(board[j][i]);
            }
        }

        //grid(3 * 3) check , whether any number comes twice in the grid
        for(int i = 0; i < n; i+=3){
            for(int j = 0; j < m; j+=3){
                if(!checkgrid(i , j , board)){
                    return false;
                }
            }           
        }

        return true;

    }

    private boolean checkgrid(int idxI, int idxJ, char[][]board){

        int rows = idxI + 3;
        int cols = idxJ + 3;

        HashSet<Character>gridset = new HashSet();

        for(int i = idxI; i < rows; i ++){
            for(int j = idxJ; j < cols; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(gridset.contains(board[i][j])){
                    return false;
                }
                gridset.add(board[i][j]);
            }
        }

        return true;
    }
}
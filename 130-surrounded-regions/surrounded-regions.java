class Solution {
    public void solve(char[][] board) {
        //Tc : O(N x M x 4) ~= O(N x M)  ;   SC : O(N x M)
        
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        int delRow[] = {-1, 0 , + 1, 0};
        int delCol[] = { 0, +1, 0 , -1};

        //check out boundary

        for(int i = 0; i < m; i++){
            //First Row
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs(board, 0, i , vis, delRow, delCol);
            }
            //Last Row
            if(!vis[n-1][i] && board[n-1][i] == 'O'){
                dfs(board, n-1, i , vis, delRow, delCol);
            }
        }
        
        for(int i = 0; i < n; i++){
            //First Col
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(board, i, 0 , vis, delRow, delCol);
            }
            //Last Col
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(board, i, m-1 , vis, delRow, delCol);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char board[][], int row , int col , boolean vis[][], int delRow[], int delCol[]){
        int n = board.length;
        int m = board[0].length; 

        vis[row][col]  = true;

        for(int i = 0; i < 4; i++){
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false && board[nr][nc] == 'O'){
                dfs(board, nr, nc ,vis, delRow, delCol);
            }
        }

    }
}
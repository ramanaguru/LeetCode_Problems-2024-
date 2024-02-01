class Solution {
    public int numEnclaves(int[][] grid) {

        //TC : O(N * M )  ;   SC : O(N * M)
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];


        // check for boundary , qn states exit from boundary 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0|| j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1 && !vis[i][j]){
                        dfs(grid, i, j, vis);
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j =0 ; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;


    }
    public void dfs(int grid[][], int i , int j , boolean vis[][]){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || i >= n || j>= m || grid[i][j] == 0){
            return ;
        }

        if(!vis[i][j]){
            vis[i][j] = true;
            dfs(grid , i -1 , j, vis);
            dfs(grid, i ,j-1, vis);
            dfs(grid, i+1, j, vis);
            dfs(grid, i, j+1 , vis);
        }
    }

    
}
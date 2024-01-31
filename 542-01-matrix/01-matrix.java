class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Multi Source BFS
        int n = mat.length;
        int m = mat[0].length;

        int vis[][] = new int[n][m];
        int ans[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j , 0));
                    vis[i][j] = 1; //Mark it as visited
                }
                
            }
        }

        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0 , +1, 0,-1};

         while(!q.isEmpty()){
            int row    = q.peek().row;
            int col    = q.peek().col;
            int step   = q.peek().step;

            q.remove();
            ans[row][col] = step;

            //Explore 4 directions
            for(int i = 0; i < 4; i++){
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if(nr >= 0 && nr < n && nc >=0 && nc < m && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc, step+1));
                }
            }

        }

        return ans;
    }

}
class Pair{
    int row;
    int col;
    int step;

    public Pair(int row, int col, int step){
        this.row= row; 
        this.col= col;
        this.step= step;
    }
}
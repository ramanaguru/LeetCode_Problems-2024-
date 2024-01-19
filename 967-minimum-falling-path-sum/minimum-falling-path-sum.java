RECURSION ---> MEMO ----> TABULATION


//TABULATION CODE WILL GET SUBMITTED
class Solution {
    public int minFallingPathSum(int[][] mat) {

        int mini = Integer.MAX_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        
        for(int i = 0; i < m ;i++){
            dp[0][i] = mat[0][i];
        }

        for(int i = 1; i <n ; i++){
            for(int j = 0; j < m; j++){
                //Possibilities of diretion ---> up , left Diagonal, right diagonal;
                int up = Integer.MAX_VALUE;
                int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;

                up = mat[i][j] + dp[i-1][j];
                if(j > 0){
                    ld = mat[i][j] + dp[i-1][j-1];
                }   
                if(j < m-1){
                    rd = mat[i][j] + dp[i-1][j+1];
                } 

                dp[i][j] = Math.min(up,Math.min(ld, rd));

            }
        }

        for(int i = 0; i < m; i++){
            mini = Math.min(dp[n-1][i], mini);
        }

        return mini;
    }
}

//MEMO (THIS WILL GIVE TLE)

class Solution {
    public int minFallingPathSum(int[][] mat) {

        int mini = Integer.MAX_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        for(int col = 0; col < m ; col++){
            int val = memo(mat, n-1, col, m, dp);
            mini = Math.min(mini, val);
        }

        return mini;


    }

    public int memo(int mat[][], int row , int col, int m, int dp[][]){
        if(col < 0 || col >= m){
            return (int)1e9;
        }

        if(row == 0) return mat[row][col];
        if(dp[row][col] != -1) return dp[row][col];

        int up          =   mat[row][col] + memo(mat, row-1, col, m, dp);
        int leftDiag    =   mat[row][col] + memo(mat, row-1, col-1, m, dp);
        int rightDiag   =   mat[row][col] + memo(mat, row-1, col+1, m, dp);

        return dp[row][col] =  Math.min(up, Math.min(leftDiag, rightDiag));
    }
}


//RECURSION (THIS WILL TLE)

class Solution {
    public int minFallingPathSum(int[][] mat) {
        int mini = Integer.MAX_VALUE;
        int n = mat.length;
        int m = mat[0].length;

        for(int col = 0; col < m ; col++){
            int val = recursion(mat, n-1, col, m);
            mini = Math.min(mini, val);
        }

        return mini;


    }

    public int recursion(int mat[][], int row , int col, int m){
        if(col < 0 || col >= m){
            return (int)1e9;
        }

        if(row == 0) return mat[row][col];

        int up          =   mat[row][col] + recursion(mat, row-1, col, m);
        int leftDiag    =   mat[row][col] + recursion(mat, row-1, col-1, m);
        int rightDiag   =   mat[row][col] + recursion(mat, row-1, col+1, m);

        return Math.min(up, Math.min(leftDiag, rightDiag));
    }
}

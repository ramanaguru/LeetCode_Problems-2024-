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
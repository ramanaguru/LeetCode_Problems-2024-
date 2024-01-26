class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //Tabulation 
        //Tc : O(m * n * maxMove). ; Sc: O(m * n * maxMove)
        int mod = 1000000007;

        if(startRow < 0|| startColumn < 0 || startRow >= m || startColumn >= n || maxMove == 0)return 0;

        long dp[][][] = new long[m][n][maxMove+1];

        for(int move = 1; move <= maxMove; move++){
            for(int row = 0; row < m ; row++){
                for(int col = 0; col < n ; col++){
                   
                    long up = (row - 1 >= 0) ? dp[row - 1][col][move - 1] % mod : 1;
                    long down = (row + 1 < m) ? dp[row + 1][col][move - 1] % mod : 1;
                    long left = (col - 1 >= 0) ? dp[row][col - 1][move - 1] % mod : 1;
                    long right = (col + 1 < n) ? dp[row][col + 1][move - 1] % mod : 1;


                    dp[row][col][move] = (up + down + left + right) % mod;
                }
            }
        }

        return (int)dp[startRow][startColumn][maxMove] % mod;

    }
}
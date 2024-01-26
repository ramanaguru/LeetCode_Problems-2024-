Recursion  --> Memoisation --> Tabulation
==================================================================================================================================
Recursion(TLE)
   class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod  = 1000000000+7;
        int ans = recursion(m, n , maxMove, startRow, startColumn);

        return ans % mod;
    }

    public int recursion(int i , int j , int moves , int row, int col){

        if(row == i || col == j || row < 0 || col < 0)return 1;

        if(moves == 0) return 0;

        return recursion(i , j , moves -1, row-1 , col) 
                + recursion(i , j , moves-1, row+1 , col)
                + recursion(i , j , moves-1, row , col-1)
                + recursion(i , j , moves-1, row , col+1);
    }
}
    
==================================================================================================================================
Memoisation (TLE)

    //Tc : O(m * n * maxMove). ; Sc: O(m * n * maxMove)
    
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;

        Long[][][] dp = new Long[m][n][maxMove + 1];
        for (Long[][] row : dp) {
            for (Long[] r : row) {
                Arrays.fill(r, -1L);
            }
        }

        Long ans = memo(m, n, maxMove, startRow, startColumn, dp);

        return ans.intValue() % mod;
    }

    public Long memo(int i, int j, int moves, int row, int col, Long[][][] dp) {
        if (row >= i || col >= j || row < 0 || col < 0) {
            return 1L;
        }

        if (moves == 0) {
            return 0L;
        }

        if (dp[row][col][moves] != -1) {
            return dp[row][col][moves];
        }

        Long ans = (
            memo(i, j, moves - 1, row - 1, col, dp) +
            memo(i, j, moves - 1, row + 1, col, dp) +
            memo(i, j, moves - 1, row, col - 1, dp) +
            memo(i, j, moves - 1, row, col + 1, dp)
        ) % 1000000007;

        dp[row][col][moves] = ans;
        return ans;
    }
}

==================================================================================================================================
Tabulation (Accepted)

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
==================================================================================================================================

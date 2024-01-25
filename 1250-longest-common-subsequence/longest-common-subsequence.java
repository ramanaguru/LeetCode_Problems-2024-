Recurison ---->  Memoisation ----> Tabulation

====================================================================================================================================================
1. Recursion (Gives TLE)

    //Tc :O(2 ^(n + m))  ; Sc: O(min(n, m) + n)
    
    class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n  = text1.length();
        int m = text2.length();

        int ans = lcsRecursion(n-1, m -1, text1, text2);
        
        return ans;
    }
    public int lcsRecursion(int i, int j, String t1, String t2){
        if(i < 0 || j < 0) return 0;

        if(t1.charAt(i) == t2.charAt(j)){
            return 1 + lcsRecursion(i-1, j -1, t1, t2);
        }

        return Math.max(lcsRecursion(i-1,j, t1,t2) , lcsRecursion(i,j-1, t1,t2));

    }
}


=======================================================================================================================================================
2. memoisation (Accepted)

    //Tc : O(n * m)  ; Sc : O(n * m + n)

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n  = text1.length();
        int m = text2.length();

        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        int ans = lcsMemo(n-1, m -1, text1, text2, dp);
        
        return ans;
    }

    public int lcsMemo(int i, int j, String t1, String t2, int dp[][]){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1 + lcsMemo(i-1, j -1, t1, t2,dp);
        }

        return dp[i][j] =Math.max(lcsMemo(i-1,j, t1,t2,dp) , lcsMemo(i,j-1, t1,t2,dp));

    }
}

=======================================================================================================================================================
3. Tabulation (Accepted)

    //Tc : O(n * m)  ; Sc : O(n * m)
    
    class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n  = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];
        
        //Base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;  // first col = 0
        }
        //Base case
        for(int i = 0; i <= m; i++){
            dp[0][i] = 0; // zeroth row = 0
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                }
            }
        }
   
        return dp[n][m];
    }

}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //Tc : O(n * m)  ; Sc : O(n * m)
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
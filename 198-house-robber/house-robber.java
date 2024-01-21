class Solution {
    public int rob(int[] nums) {
        //Tabulation  will get submitted bbut we can still optimise
        //Tc: O(N) ; Sc :O(N)
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        if(n == 2){
            ans = Math.max(ans, Math.max(nums[0], nums[1]) );
            return ans;
        }

        int dp[] = new int[n];
        dp[0] = nums[0];

        for(int idx = 1 ; idx < n; idx++){
            int take = nums[idx];
            if(idx > 1){
                take += dp[idx-2];
            }
            int notTake = dp[idx-1];

            dp[idx] = Math.max(take , notTake);

        }

        return dp[n-1];

    }

}
space optimised
Tc: O(N) ; Sc :O(1)
class Solution {
    public int rob(int[] nums) {
        //This is space optimised
        
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        if(n == 2){
            ans = Math.max(ans, Math.max(nums[0], nums[1]) );
            return ans;
        }

       
        int prev= nums[0];
        int prev2 = 0;

        for(int idx = 1 ; idx < n; idx++){
            int take = nums[idx];
            if(idx > 1){
                take += prev2;
            }
            int notTake = 0 + prev;

            int curr = Math.max(take , notTake);

            prev2 = prev;
            prev = curr;

        }

        return prev;

    }

}

========================================================================================================================
Tabulation
    TC : O(N)  ; Sc: O(N)
class Solution {
    public int rob(int[] nums) {
        //Tabulation  will get submitted bbut we can still optimise
        
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

========================================================================================================================
Memo
    TC : O(2^N)  ; Sc: O(N)
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        if(n == 2){
            ans = Math.max(ans, Math.max(nums[0], nums[1]) );
            return ans;
        }

        int dp[] = new int[n];
        
        Arrays.fill(dp, -1);

        ans = memo(nums, n-1 , dp);
        return ans;

    }
    public int memo(int nums[], int idx, int dp[]){
        if(idx == 0) return nums[idx];

        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int take    =  nums[idx] + memo(nums, idx -2, dp);

        int notTake =  memo(nums, idx-1,dp);

        return dp[idx] = Math.max(take,notTake);
    }
}

========================================================================================================================

Recursion
    TC : O(2^N)  ; Sc: O(N+N)
    class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        if(n == 2){
            ans = Math.max(ans, Math.max(nums[0], nums[1]) );
            return ans;
        }
        ans = recursion(nums, n-1);
        return ans;

    }
    public int recursion(int nums[], int idx){
        if(idx == 0) return nums[idx];

        if(idx < 0) return 0;

        int take    =  nums[idx] + recursion(nums, idx -2);

        int notTake =  recursion(nums, idx-1);

        return Math.max(take,notTake);
    }
}

========================================================================================================================

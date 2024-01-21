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
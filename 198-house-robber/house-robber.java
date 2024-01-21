class Solution {
    public int rob(int[] nums) {
        //Tc: O(N) ; Sc :O(1)
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
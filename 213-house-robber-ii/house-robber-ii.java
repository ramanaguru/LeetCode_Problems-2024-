class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n]; // Robbing from the 1st house
        int[] dp2 = new int[n]; // Robbing from the 2nd house onwards

        // Initialize the first two elements of dp1 and dp2
        dp1[0] = nums[0];
        dp2[0] = 0;
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = nums[1];

        // Populate dp1 (Robbing from the 1st house)
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }

        // Populate dp2 (Robbing from the 2nd house onwards)
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }

        // Return the maximum value between the last elements of dp1 and dp2
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}

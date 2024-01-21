class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];

        int nums1[] = new int[n];
        int nums2[] = new int[n];

        for(int i = 0; i < n; i++){
            if(i != n-1){
                nums1[i] = nums[i];
            }
            if( i != 0){
                nums2[i] = nums[i];
            }
        }

        int ans1 = func(nums1);
        int ans2 = func(nums2);

        return Math.max(ans1, ans2);
    }
    public int func(int nums[]){
        int n = nums.length;

        int prev = nums[0];
        int prev2 =0;

        for(int i =1; i< n; i++){
            int take = nums[i];
            if(i > 1){
                take += prev2;
            }
            int notTake = prev;

            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
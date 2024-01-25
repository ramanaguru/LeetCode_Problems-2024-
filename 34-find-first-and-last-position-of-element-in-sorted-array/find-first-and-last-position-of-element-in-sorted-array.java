class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];
        ans[0]  = firstPos(nums, target, n);
        ans[1]  = lastPos(nums, target, n);

        return ans;
    }
    public int firstPos(int nums[], int x, int n){
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == x){
                ans = mid;
                high = mid -1;
            }
            else if(nums[mid] < x){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }

        }

        return ans;
    }

      public int lastPos(int nums[], int x, int n){
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == x){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid] < x){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }

        }

        return ans;
    }
}
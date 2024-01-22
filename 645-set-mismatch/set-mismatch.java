class Solution {
    public int[] findErrorNums(int[] nums) {
        int freq[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            freq[nums[i]-1]++;
        }

        int ans[] = new int[2];

        for(int i  = 0; i < nums.length; i++){
            if(freq[i] > 1){
                ans[0] = i+1;
            }
            if(freq[i] == 0){
                ans[1] = i +1;
            }
        }

        return ans;


        
    }
}


====================================================================================================================================

Using HashSet

class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = 0;
        int miss = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                dup = nums[i];
            }
            set.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                miss = i;
            }
        }

        return new int[]{dup, miss};
    }
}

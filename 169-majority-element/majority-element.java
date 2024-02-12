class Solution {
    public int majorityElement(int[] nums) {

        //Tc: O(N)  ; Sc :O(N)
        
        int count = 0;
        int n = nums.length;

       int curr = nums[0];

        for(int i = 0 ; i < n; i++){
           if(count == 0){
               count = 1;
               curr = nums[i]; 
           }
           else if(curr != nums[i]){
               count--;
           }
           else{
               count++;
           }
        }

        int ans = 0;

        int maj = n/2;

        for(int i = 0; i < n; i++){
            if(curr == nums[i]){
                ans++;
            }
          
        }

        if(ans > maj){
            return curr;
        }

        return ans;
        
    }
}
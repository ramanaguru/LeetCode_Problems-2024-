class Solution {
    public int[] findPeakGrid(int[][] mat) {
        //TC : O(n log(m))     ;   SC : O(1)
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = (low + high)/2;
            // we find maximum because we have to check top, bottom, left, right if we use maximum then our element is definitely
            // greater than top and bottom. so we need to check only left and right i.e. our problem is reduced to find peak in 1d

            int row = findmaxi(mat, mid);

            int left = -1;
            int right = -1;

            // handling edge cases
            if(mid - 1 >= 0){
                left = mat[row][mid -1];
            }
            if(mid + 1 < m){
                right = mat[row][mid + 1];
            }
            // we find peak element
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }
            // our peak is on the right side of mid so eliminate the left part  
            else if(mat[row][mid] > left){
                low = mid + 1;
            }
            // our peak is on the left side of mid so eliminate the right part
            else{
                high = mid - 1;
            }


        }
        return new int[]{-1,-1};

    }

    public int findmaxi(int mat[][], int mid){
         // find row index of max element and col index is given by mid
        int index = -1;
        int maxi = Integer.MIN_VALUE;


        for(int i = 0; i < mat.length; i++){
            //i is ROW , FOR OUR REFERENCE
            int ele = mat[i][mid];

            if(ele > maxi){
                maxi = Math.max(maxi, ele);
                index = i;
            }
        }

        return index;
    }
}
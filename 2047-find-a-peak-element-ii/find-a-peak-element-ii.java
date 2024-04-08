class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        while(low <= high){
            
            int mid = (low + high)/2;

            int row = findmaxi(mat, mid);
            int left = -1;
            int right = -1;
            if(mid - 1 >= 0){
                left = mat[row][mid -1];
            }
            if(mid + 1 < m){
                right = mat[row][mid + 1];
            }

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid] > left){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }


        }
        return new int[]{-1,-1};

    }

    public int findmaxi(int mat[][], int mid){
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
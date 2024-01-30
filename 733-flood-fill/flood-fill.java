class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //TC : O(N x M + N x M x 4) ~= O(N * M)   ;   SC: O(N x M + N x M)
        int initial_col = image[sr][sc];

         if (initial_col == color) {
            return image;  // No need to fill if the new color is the same as the initial color
        }

        int ans[][] = image;

        //4 directions
        int delRow[] = {-1, 0 , +1, 0};
        int delCol[] = {0, +1, 0 , -1};

        dfs(image, sr , sc, color, initial_col, delRow, delCol, ans);


        return ans;
    }


    public void dfs(int image[][], int row, int col, int colorToPaint, int initial_col, int delRow[], int delCol[], int ans[][]){
        ans[row][col] = colorToPaint;

        int n = image.length;
        int m = image[0].length;

        for(int i = 0 ; i < 4 ; i++){
            int nR = row + delRow[i];
            int nC = col + delCol[i];

            if(nR >= 0 && nR < n && nC >= 0 && nC < m && image[nR][nC] == initial_col){
                dfs(image, nR, nC , colorToPaint, initial_col, delRow, delCol, ans );
            }
        }

    }
}
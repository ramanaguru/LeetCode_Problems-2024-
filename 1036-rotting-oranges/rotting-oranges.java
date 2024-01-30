class Solution {


    //Tc : O(N * M)    ;  SC  :O(N * M)

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshcount = 0;

        Queue<Pair>q = new LinkedList<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    freshcount++;
                }
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }
            }
        }

        if(q.isEmpty()){
            if(freshcount == 0) return 0;
            else{
                return -1;
            }
        }

        int total = 0;    // from observation we know total - 1 will be our output


        while(!q.isEmpty()){
            total++;
            int size = q.size();

            for(int i = 0 ; i < size; i++){
                Pair ele = q.poll();
                int x = ele.first;
                int y = ele.second;

                //Qn states -> 4 directions
                if(x-1 >= 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    q.add(new Pair(x-1, y ));
                }

                if(x+1 < n && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    q.add(new Pair(x+1, y ));
                }
                if(y-1 >= 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    q.add(new Pair(x, y-1 ));
                }
                if(y+1 <  m && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    q.add(new Pair(x, y +1));
                }

            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return total - 1;
    }

    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
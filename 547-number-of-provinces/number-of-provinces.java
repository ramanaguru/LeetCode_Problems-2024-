class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>() );
        }  

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        int count = 0;
        boolean vis[] = new boolean[n+1];

        for(int i = 0 ; i < n; i++){
            if(vis[i] == false){
                dfs(adj, vis, i);
                count++;
            }
        }

        return count;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int s){
        if(vis[s] == true) return ;
        vis[s] = true;

        for(int v : adj.get(s)){
            if(vis[v] == false){
                dfs(adj, vis, v);
            }
        }

           
    }
}
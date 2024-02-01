class Solution {
    public boolean isBipartite(int[][] graph) {

        // TC : O(V + E) ;   SC : O(V)
        int n = graph.length;

        int color[] = new int[n+1];

        Arrays.fill(color, -1); // -1 indicates not colored

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(bfs(i, graph, color) == false){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int i, int graph[][], int color[]){
        Queue<Integer>q = new LinkedList<>();
        q.add(i);
        color[i] = 0; 

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(Integer it : graph[node]){
                if(color[it] == -1){
                    color[it] = 1 - color[node]; // making opposite color , if its 0 --> 1 - 0 = 1 , if its 1 --> 1 -1 = 0
                    q.add(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }

        return true;
    }
}
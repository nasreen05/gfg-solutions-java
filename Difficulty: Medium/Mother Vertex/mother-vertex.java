class Solution {
    private boolean[] visited;
    private void dfs(int v, List<List<Integer>> adj) {
        visited[v] = true;
        for(int nei : adj.get(v)) {
            if(!visited[nei]) {
                dfs(nei, adj);
            }
        }
    }
    
    public int findMotherVertex(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        visited = new boolean[V];
        int candidate = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(i, adj);
                candidate = i;
            }
        }
        
        visited = new boolean[V];
        dfs(candidate, adj);
        for(boolean b : visited) {
            if(!b) return -1;
        }
        
        return candidate;
    }
}
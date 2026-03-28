import java.util.*;

class Solution {

    static int timer;

    static void dfs(int node, int parent,
                    ArrayList<ArrayList<Integer>> adj,
                    int[] vis, int[] disc, int[] low,
                    int[] mark) {

        vis[node] = 1;
        disc[node] = low[node] = timer++;
        int child = 0;

        for (int it : adj.get(node)) {

            if (it == parent) continue;

            if (vis[it] == 0) {

                dfs(it, node, adj, vis, disc, low, mark);

                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= disc[node] && parent != -1) {
                    mark[node] = 1;
                }

                child++;

            } else {
                low[node] = Math.min(low[node], disc[it]);
            }
        }

        if (parent == -1 && child > 1) {
            mark[node] = 1;
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];

        timer = 0;

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, adj, vis, disc, low, mark);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (mark[i] == 1)
                result.add(i);
        }

        if (result.size() == 0) {
            result.add(-1);
        }

        return result;
    }
}

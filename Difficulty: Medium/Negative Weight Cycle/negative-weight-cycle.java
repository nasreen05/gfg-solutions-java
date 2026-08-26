class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {

        int[] dist = new int[V];

        // All vertices are considered reachable
        // so that we can detect a negative cycle
        // anywhere in the graph.
        for (int i = 0; i < V - 1; i++) {

            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            // No update means no negative cycle
            if (!updated) {
                break;
            }
        }

        // One extra relaxation
        // If possible, negative cycle exists
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[v] > dist[u] + w) {
                return true;
            }
        }

        return false;
    }
}
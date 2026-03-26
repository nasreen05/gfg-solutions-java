import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // Step 2: Initialize arrays
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[V];

        dist[0] = 0;
        ways[0] = 1;

        // Step 3: Min heap
        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.add(new long[]{0, 0});

        // Step 4: Dijkstra Algorithm
        while(!pq.isEmpty()) {

            long[] curr = pq.poll();

            long currDist = curr[0];
            int node = (int) curr[1];

            if(currDist > dist[node]) {
                continue;
            }

            for(int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                long weight = neighbor[1];

                long newDist = currDist + weight;

                if(newDist < dist[nextNode]) {

                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];

                    pq.add(new long[]{newDist, nextNode});
                }

                else if(newDist == dist[nextNode]) {

                    ways[nextNode] += ways[node];
                }
            }
        }

        return ways[V - 1];
    }
}

class Solution {
    public int longestCycle(int V, int[][] edges) {

        // Convert edges[][] into outgoing array
        int[] out = new int[V];
        for(int i = 0; i < V; i++)
            out[i] = -1;

        for(int[] e : edges)
            out[e[0]] = e[1];

        boolean[] visited = new boolean[V];
        int maxCycle = -1;

        for(int i = 0; i < V; i++) {

            if(visited[i]) continue;

            int curr = i;
            int step = 0;

            // store visit time for current path
            HashMap<Integer, Integer> map = new HashMap<>();

            while(curr != -1 && !visited[curr]) {

                visited[curr] = true;
                map.put(curr, step++);

                curr = out[curr];

                if(curr != -1 && map.containsKey(curr)) {
                    int cycleLen = step - map.get(curr);
                    maxCycle = Math.max(maxCycle, cycleLen);
                    break;
                }
            }
        }

        return maxCycle;
    }
}

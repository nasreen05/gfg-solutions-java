class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // dist[i][j] = minimum upward moves needed to reach (i, j)
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Deque for 0-1 BFS
        java.util.ArrayDeque<int[]> deque = new java.util.ArrayDeque<>();

        dist[r][c] = 0;
        deque.addFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();

            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                // Moving upward costs 1.
                // Other moves cost 0.
                int cost = (nx < x) ? 1 : 0;

                int newUp = dist[x][y] + cost;

                if (newUp < dist[nx][ny]) {
                    dist[nx][ny] = newUp;

                    if (cost == 0) {
                        deque.addFirst(new int[]{nx, ny});
                    } else {
                        deque.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '#') {
                    continue;
                }

                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int upMoves = dist[i][j];

                // down = up + (currentRow - startRow)
                int downMoves = upMoves + (i - r);

                if (upMoves <= u && downMoves <= d) {
                    count++;
                }
            }
        }

        return count;
    }
}
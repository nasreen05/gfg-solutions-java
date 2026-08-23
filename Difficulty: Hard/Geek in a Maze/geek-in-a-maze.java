import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // Starting cell is an obstacle
        if (mat[r][c] == '#') {
            return 0;
        }

        // dist[i][j] = minimum number of UP moves
        // required to reach (i, j)
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.addFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            int[] cur = dq.pollFirst();

            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                // Outside the maze
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // Obstacle
                if (mat[nx][ny] == '#') {
                    continue;
                }

                // Up move costs 1.
                // Down, left and right cost 0.
                int cost = (nx < x) ? 1 : 0;

                int newDist = dist[x][y] + cost;

                if (newDist < dist[nx][ny]) {

                    dist[nx][ny] = newDist;

                    if (cost == 0) {
                        dq.addFirst(new int[]{nx, ny});
                    } else {
                        dq.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == '#') {
                    continue;
                }

                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                // Minimum upward moves
                int upMoves = dist[i][j];

                // From:
                // row difference = downMoves - upMoves
                //
                // i - r = downMoves - upMoves
                //
                // downMoves = upMoves + (i - r)
                int downMoves = upMoves + (i - r);

                if (upMoves <= u && downMoves <= d) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
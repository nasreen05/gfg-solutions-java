import java.util.*;

class Solution {
    
    private final int[][] DIR = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    private void bfs(Queue<int[]> q, boolean[][] vis, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                
                if (vis[nr][nc])
                    continue;
                
                // reverse flow condition
                if (mat[nr][nc] >= mat[r][c]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
    
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];
        
        Queue<int[]> qp = new LinkedList<>();
        Queue<int[]> qq = new LinkedList<>();
        
        // Station P (top row + left column)
        for (int i = 0; i < n; i++) {
            p[i][0] = true;
            qp.offer(new int[]{i, 0});
        }
        
        for (int j = 0; j < m; j++) {
            if (!p[0][j]) {
                p[0][j] = true;
                qp.offer(new int[]{0, j});
            }
        }
        
        // Station Q (bottom row + right column)
        for (int i = 0; i < n; i++) {
            q[i][m - 1] = true;
            qq.offer(new int[]{i, m - 1});
        }
        
        for (int j = 0; j < m; j++) {
            if (!q[n - 1][j]) {
                q[n - 1][j] = true;
                qq.offer(new int[]{n - 1, j});
            }
        }
        
        bfs(qp, p, mat);
        bfs(qq, q, mat);
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j]) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
class Solution {
    
    int n, m;
    
    // Directions: up, down, left, right
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    void dfs(int[][] grid, int x, int y, boolean[][] vis) {
        
        vis[x][y] = true;
        
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                grid[nx][ny] == 1 && !vis[nx][ny]) {
                
                dfs(grid, nx, ny, vis);
            }
        }
    }
    
    int cntOnes(int[][] grid) {
        
        n = grid.length;
        m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        // Traverse first & last column
        for (int i = 0; i < n; i++) {
            
            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs(grid, i, 0, vis);
            }
            
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(grid, i, m - 1, vis);
            }
        }
        
        // Traverse first & last row
        for (int j = 0; j < m; j++) {
            
            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(grid, 0, j, vis);
            }
            
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                dfs(grid, n - 1, j, vis);
            }
        }
        
        // Count enclosed 1s
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
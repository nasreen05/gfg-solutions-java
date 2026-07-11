class Solution {
    
    int n, m;
    int maxLen;
    
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        
        // Source or destination blocked
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        
        maxLen = -1;
        
        boolean[][] visited = new boolean[n][m];
        dfs(mat, xs, ys, xd, yd, visited, 0);
        
        return maxLen;
    }
    
    private void dfs(int[][] mat, int x, int y, int xd, int yd,
                     boolean[][] visited, int len) {
        
        if (x == xd && y == yd) {
            maxLen = Math.max(maxLen, len);
            return;
        }
        
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (nx >= 0 && nx < n &&
                ny >= 0 && ny < m &&
                mat[nx][ny] == 1 &&
                !visited[nx][ny]) {
                
                dfs(mat, nx, ny, xd, yd, visited, len + 1);
            }
        }
        
        // Backtrack
        visited[x][y] = false;
    }
}
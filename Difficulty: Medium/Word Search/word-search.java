class Solution {

    int n, m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public boolean isWordExist(char[][] mat, String word) {
        n = mat.length;
        m = mat[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] mat, String word,
                        int x, int y, int idx,
                        boolean[][] visited) {

        if (idx == word.length()) return true;

        if (x < 0 || y < 0 || x >= n || y >= m ||
            visited[x][y] || mat[x][y] != word.charAt(idx)) {
            return false;
        }

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            if (dfs(mat, word, x + dx[d], y + dy[d], idx + 1, visited)) {
                return true;
            }
        }

        // 🔴 THIS LINE MUST EXIST — YOUR ERROR IS HERE
        visited[x][y] = false;

        return false;
    }
}

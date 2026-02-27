class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Step 1: Create prefix sum matrix
        int[][] pre = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pre[i][j] = mat[i][j];
                
                if(i > 0)
                    pre[i][j] += pre[i-1][j];
                if(j > 0)
                    pre[i][j] += pre[i][j-1];
                if(i > 0 && j > 0)
                    pre[i][j] -= pre[i-1][j-1];
            }
        }
        
        int count = 0;
        
        // Step 2: Try all possible square sizes
        for(int size = 1; size <= Math.min(n, m); size++) {
            
            for(int i = 0; i + size - 1 < n; i++) {
                for(int j = 0; j + size - 1 < m; j++) {
                    
                    int r2 = i + size - 1;
                    int c2 = j + size - 1;
                    
                    int sum = pre[r2][c2];
                    
                    if(i > 0)
                        sum -= pre[i-1][c2];
                    if(j > 0)
                        sum -= pre[r2][j-1];
                    if(i > 0 && j > 0)
                        sum += pre[i-1][j-1];
                    
                    if(sum == x)
                        count++;
                }
            }
        }
        
        return count;
    }
}

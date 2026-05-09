class Solution {
    public int countSpanTree(int n, int[][] edges) {
        // Kirchhoff's Matrix Tree Theorem
        
        // Step 1: Build Laplacian matrix
        long[][] lap = new long[n][n];
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }
        
        // Special case
        if (n == 1) return 1;
        
        // Step 2: Create cofactor matrix by removing
        // last row and last column
        long[][] mat = new long[n - 1][n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                mat[i][j] = lap[i][j];
            }
        }
        
        // Step 3: Compute determinant
        return (int)Math.round(determinant(mat, n - 1));
    }
    
    private double determinant(long[][] matrix, int n) {
        double[][] a = new double[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = matrix[i][j];
            }
        }
        
        double det = 1;
        
        for (int i = 0; i < n; i++) {
            
            // Find pivot
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[j][i]) > Math.abs(a[pivot][i])) {
                    pivot = j;
                }
            }
            
            // If pivot is zero
            if (Math.abs(a[pivot][i]) < 1e-9) {
                return 0;
            }
            
            // Swap rows if needed
            if (pivot != i) {
                double[] temp = a[i];
                a[i] = a[pivot];
                a[pivot] = temp;
                det *= -1;
            }
            
            det *= a[i][i];
            
            // Eliminate below
            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                
                for (int k = i; k < n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }
        
        return det;
    }
}
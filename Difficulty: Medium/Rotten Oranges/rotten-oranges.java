import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Count fresh oranges & add rotten oranges to queue
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                else if(mat[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        // If no fresh oranges
        if(fresh == 0) return 0;
        
        int time = 0;
        
        // Directions: up, down, left, right
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        // Step 2: BFS traversal
        while(!q.isEmpty()){
            
            int size = q.size();
            boolean rottenThisRound = false;
            
            for(int i = 0; i < size; i++){
                
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                for(int[] d : dir){
                    
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols 
                       && mat[nr][nc] == 1){
                        
                        mat[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        fresh--;
                        rottenThisRound = true;
                    }
                }
            }
            
            if(rottenThisRound) time++;
        }
        
        // Step 3: Check remaining fresh oranges
        return fresh == 0 ? time : -1;
    }
}

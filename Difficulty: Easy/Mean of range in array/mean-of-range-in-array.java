import java.util.*;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        // Step 1: Build prefix sum array
        long[] prefix = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        // Step 2: Process queries
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            long sum = prefix[r + 1] - prefix[l];
            int length = r - l + 1;
            
            result.add((int)(sum / length)); // floor mean automatically
        }
        
        return result;
    }
}

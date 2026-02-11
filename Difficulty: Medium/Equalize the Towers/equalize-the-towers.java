import java.util.*;

class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        
        // Create pair array
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = cost[i];
        }
        
        // Sort based on heights
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // Find total cost (total weight)
        long totalWeight = 0;
        for(int i = 0; i < n; i++) {
            totalWeight += arr[i][1];
        }
        
        // Find weighted median
        long currWeight = 0;
        int medianHeight = 0;
        
        for(int i = 0; i < n; i++) {
            currWeight += arr[i][1];
            if(currWeight >= (totalWeight + 1) / 2) {
                medianHeight = arr[i][0];
                break;
            }
        }
        
        // Calculate minimum cost
        long minCost = 0;
        for(int i = 0; i < n; i++) {
            minCost += (long)Math.abs(heights[i] - medianHeight) * cost[i];
        }
        
        return (int)minCost;
    }
}

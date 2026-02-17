import java.util.*;

class Solution {
    public static int overlapInt(int[][] arr) {
        
        int n = arr.length;
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        // Separate start and end times
        for (int i = 0; i < n; i++) {
            start[i] = arr[i][0];
            end[i] = arr[i][1];
        }
        
        // Sort both arrays
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 0, j = 0;
        int currentOverlap = 0;
        int maxOverlap = 0;
        
        // Sweep line technique
        while (i < n && j < n) {
            
            // Since intervals are inclusive
            if (start[i] <= end[j]) {
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                i++;
            } else {
                currentOverlap--;
                j++;
            }
        }
        
        return maxOverlap;
    }
}

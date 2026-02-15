import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        
        int n = arr.size();
        
        // Edge cases
        if (m == 0 || n == 0)
            return 0;
        
        if (m > n)
            return -1;
        
        // Sort the array
        Collections.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        
        // Find the minimum difference
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
}

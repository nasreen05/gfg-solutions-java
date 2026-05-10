import java.util.*;

class Solution {
    
    static class Task {
        int diff, aProfit, bProfit;
        
        Task(int diff, int aProfit, int bProfit) {
            this.diff = diff;
            this.aProfit = aProfit;
            this.bProfit = bProfit;
        }
    }

    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        
        Task[] tasks = new Task[n];
        
        // Store absolute difference and profits
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(Math.abs(a[i] - b[i]), a[i], b[i]);
        }
        
        // Sort by maximum profit difference descending
        Arrays.sort(tasks, (t1, t2) -> t2.diff - t1.diff);
        
        int profit = 0;
        
        for (Task t : tasks) {
            
            // Prefer machine with higher profit
            if ((t.aProfit >= t.bProfit && x > 0) || y == 0) {
                profit += t.aProfit;
                x--;
            } else {
                profit += t.bProfit;
                y--;
            }
        }
        
        return profit;
    }
}
class Solution {
    public int optimalKeys(int n) {
        // dp[i] = maximum number of A's possible with i key presses
        int[] dp = new int[n + 1];
        
        // For small values, pressing A every time is optimal
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            
            // Try all possible breakpoints
            // At breakpoint b:
            // Use Ctrl+A, Ctrl+C, then multiple Ctrl+V
            for (int b = 1; b <= i - 3; b++) {
                int curr = dp[b] * (i - b - 1);
                dp[i] = Math.max(dp[i], curr);
            }
        }
        
        return dp[n];
    }
}
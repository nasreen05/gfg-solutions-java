class Solution {
    
    int[][] dp;
    int[][] prefix;
    
    public int validGroups(String s) {
        int n = s.length();
        
        // prefix sum of digits
        prefix = new int[n + 1][1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1][0] = prefix[i][0] + (s.charAt(i) - '0');
        }
        
        // Maximum possible digit sum = 9 * 100 = 900
        dp = new int[n + 1][901];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 900; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(0, 0, s);
    }
    
    // idx = current position
    // prevSum = previous group digit sum
    int solve(int idx, int prevSum, String s) {
        int n = s.length();
        
        // Reached end -> one valid grouping
        if (idx == n) {
            return 1;
        }
        
        if (dp[idx][prevSum] != -1) {
            return dp[idx][prevSum];
        }
        
        int ans = 0;
        int currSum = 0;
        
        // Try every possible next substring
        for (int i = idx; i < n; i++) {
            currSum += (s.charAt(i) - '0');
            
            // Non-decreasing condition
            if (currSum >= prevSum) {
                ans += solve(i + 1, currSum, s);
            }
        }
        
        return dp[idx][prevSum] = ans;
    }
}
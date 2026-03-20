class Solution {
    static boolean match(String wild, String pattern) {
        int n = wild.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case
        dp[0][0] = true;

        // Handle '*' matching empty pattern
        for (int i = 1; i <= n; i++) {
            if (wild.charAt(i - 1) == '*')
                dp[i][0] = dp[i - 1][0];
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char w = wild.charAt(i - 1);
                char p = pattern.charAt(j - 1);

                if (w == p || w == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (w == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } 
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}

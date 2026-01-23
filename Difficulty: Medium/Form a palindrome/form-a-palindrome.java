class Solution {
    static int countMin(String str) {
        int n = str.length();
        String rev = new StringBuilder(str).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        // LCS between str and rev
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lps = dp[n][n];
        return n - lps;
    }
}

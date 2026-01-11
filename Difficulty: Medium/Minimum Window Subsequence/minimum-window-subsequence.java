class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // dp[i][j] = start index of subsequence s2[0..j-1] ending at s1[i-1]
        int[][] dp = new int[n + 1][m + 1];

        // Empty s2 matches at every position
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Non-empty s2 cannot match empty s1
        for (int j = 1; j <= m; j++) {
            dp[0][j] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int start = -1;
        int minLen = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dp[i][m] != -1) {
                int len = i - dp[i][m];
                if (len < minLen) {
                    minLen = len;
                    start = dp[i][m];
                }
            }
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }
}


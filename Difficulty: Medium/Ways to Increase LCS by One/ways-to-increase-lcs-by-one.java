class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Prefix LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int L = dp[n][m];

        int[][] suf = new int[n + 1][m + 1];

        // Suffix LCS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    suf[i][j] = 1 + suf[i + 1][j + 1];
                else
                    suf[i][j] = Math.max(suf[i + 1][j], suf[i][j + 1]);
            }
        }

        int ans = 0;

        // Try every insertion position
        for (int i = 0; i <= n; i++) {

            for (char ch = 'a'; ch <= 'z'; ch++) {

                boolean possible = false;

                for (int j = 0; j < m; j++) {
                    if (s2.charAt(j) == ch &&
                        dp[i][j] + suf[i][j + 1] == L) {
                        possible = true;
                        break;
                    }
                }

                if (possible) ans++;
            }
        }

        return ans;
    }
}
class Solution {
    private static final int MOD = 1000000007;

    public int countWays(int n, int m) {
        if (n < m) return 1;

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int i = 1; i <= n; i++) {
            long ans = ways[i - 1];
            if (i >= m) ans += ways[i - m];
            ways[i] = (int)(ans % MOD);
        }

        return ways[n];
    }
}
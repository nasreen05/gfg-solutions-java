
class Solution {
    public int maxTask(int[] h, int[] l) {

        int n = h.length;

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Perform low-effort task on day i-1
            int low = dp[i - 1] + l[i - 1];

            // Perform high-effort task on day i-1
            int high = h[i - 1];

            if (i >= 2) {
                high += dp[i - 2];
            }

            // We can also choose to do nothing
            dp[i] = Math.max(dp[i - 1], Math.max(low, high));
        }

        return dp[n];
    }
}

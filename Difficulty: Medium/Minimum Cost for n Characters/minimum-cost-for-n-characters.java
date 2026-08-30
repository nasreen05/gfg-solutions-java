import java.util.*;

class Solution {
    public int minCost(int n, int i, int d, int c) {

        long[] dp = new long[n + 1];

        // Deque stores indices k.
        // We maintain minimum of:
        // dp[k] + 2*k*d
        Deque<Integer> dq = new ArrayDeque<>();

        long[] value = new long[n + 1];

        for (int x = 1; x <= n; x++) {

            // Add k = x - 1 to the sliding window
            int k = x - 1;

            if (k >= 1) {
                value[k] = dp[k] + 2L * k * d;

                while (!dq.isEmpty() && value[dq.peekLast()] >= value[k]) {
                    dq.pollLast();
                }

                dq.offerLast(k);
            }

            // Valid k values are ceil(x/2) ... x-1
            int low = (x + 1) / 2;

            // Remove indices outside the window
            while (!dq.isEmpty() && dq.peekFirst() < low) {
                dq.pollFirst();
            }

            // Option 1: Insert one character
            dp[x] = dp[x - 1] + i;

            // Option 2:
            // Reach k characters, copy -> 2*k,
            // then delete (2*k - x) characters.
            if (!dq.isEmpty()) {
                long copyAndDelete =
                        c - 1L * x * d + value[dq.peekFirst()];

                dp[x] = Math.min(dp[x], copyAndDelete);
            }
        }

        return (int) dp[n];
    }
}
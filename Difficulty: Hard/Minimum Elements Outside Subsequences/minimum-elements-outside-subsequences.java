class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;

        // dp[i][j]:
        // maximum number of elements selected when
        // i is the last element of increasing subsequence
        // j is the last element of decreasing subsequence
        //
        // We process elements from left to right.
        int[][] dp = new int[n][n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }

        // More convenient DP:
        // dp[i][j] = maximum selected elements
        // after processing up to current position,
        // where i and j represent last positions.
        //
        // Since n <= 100, use state (incLast, decLast)
        // and process every element.

        int[][] curr = new int[n + 1][n + 1];

        // -1 means unreachable
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                curr[i][j] = -1;
            }
        }

        curr[0][0] = 0;

        for (int k = 0; k < n; k++) {
            int[][] next = new int[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    next[i][j] = -1;
                }
            }

            for (int inc = 0; inc <= k; inc++) {
                for (int dec = 0; dec <= k; dec++) {

                    if (curr[inc][dec] == -1)
                        continue;

                    int value = curr[inc][dec];

                    // 1. Don't use current element
                    next[inc][dec] = Math.max(next[inc][dec], value);

                    // 2. Put current element into increasing subsequence
                    if (inc == 0 || arr[k] > arr[inc - 1]) {
                        next[k + 1][dec] =
                            Math.max(next[k + 1][dec], value + 1);
                    }

                    // 3. Put current element into decreasing subsequence
                    if (dec == 0 || arr[k] < arr[dec - 1]) {
                        next[inc][k + 1] =
                            Math.max(next[inc][k + 1], value + 1);
                    }
                }
            }

            curr = next;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                ans = Math.max(ans, curr[i][j]);
            }
        }

        return n - ans;
    }
}
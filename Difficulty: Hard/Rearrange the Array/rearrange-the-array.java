class Solution {
    static final long MOD = 1000000007L;

    int minOperations(int[] b) {
        int n = b.length;

        boolean[] vis = new boolean[n];
        int[] maxPower = new int[n + 1];

        // Find cycle lengths
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;

                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1; // convert to 0-based index
                    len++;
                }

                // Prime factorization of cycle length
                int temp = len;
                for (int p = 2; p * p <= temp; p++) {
                    int cnt = 0;
                    while (temp % p == 0) {
                        cnt++;
                        temp /= p;
                    }
                    maxPower[p] = Math.max(maxPower[p], cnt);
                }

                if (temp > 1) {
                    maxPower[temp] = Math.max(maxPower[temp], 1);
                }
            }
        }

        // Construct LCM modulo MOD
        long ans = 1;

        for (int p = 2; p <= n; p++) {
            for (int i = 0; i < maxPower[p]; i++) {
                ans = (ans * p) % MOD;
            }
        }

        return (int) ans;
    }
}
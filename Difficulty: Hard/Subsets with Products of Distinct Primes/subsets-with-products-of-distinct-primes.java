class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int[] freq = new int[31];
        for (int x : arr) freq[x]++;

        int ones = freq[1];

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int num = 2; num <= 30; num++) {

            if (freq[num] == 0) continue;

            int x = num;
            int mask = 0;
            boolean valid = true;

            for (int i = 0; i < 10; i++) {
                int p = primes[i];

                if (x % (p * p) == 0) {
                    valid = false;
                    break;
                }

                if (x % p == 0)
                    mask |= (1 << i);
            }

            if (!valid) continue;

            long[] next = dp.clone();

            for (int m = 0; m < (1 << 10); m++) {
                if ((m & mask) == 0) {
                    next[m | mask] =
                            (next[m | mask] + dp[m] * freq[num]) % MOD;
                }
            }

            dp = next;
        }

        long ans = 0;
        for (int m = 1; m < (1 << 10); m++) {
            ans = (ans + dp[m]) % MOD;
        }

        long pow = 1;
        long base = 2;
        int exp = ones;

        while (exp > 0) {
            if ((exp & 1) == 1)
                pow = (pow * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }

        ans = (ans * pow) % MOD;

        return (int) ans;
    }
}
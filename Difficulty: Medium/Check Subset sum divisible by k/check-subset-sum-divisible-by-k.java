class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;

        // Pigeonhole principle:
        // If there are more than k numbers, some non-empty subset
        // must have sum divisible by k.
        if (n > k) return true;

        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] next = dp.clone();

            int rem = num % k;
            next[rem] = true; // subset containing only num

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    next[(r + rem) % k] = true;
                }
            }

            dp = next;

            if (dp[0]) return true;
        }

        return false;
    }
}
class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long result = 0;

        // Check all 32 bits
        for (int bit = 0; bit < 32; bit++) {
            long count1 = 0;

            // Count elements with current bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count1++;
                }
            }

            long count0 = n - count1;

            // Contribution of this bit
            result += count1 * count0 * (1L << bit);
        }

        return result;
    }
}
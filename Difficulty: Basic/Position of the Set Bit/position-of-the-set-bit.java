class Solution {
    public int findPosition(int n) {
        // Step 1: check if n is 0 or not a power of 2
        if (n == 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        int position = 1;

        // Step 2: find position of the only set bit
        while (n > 1) {
            n = n >> 1;
            position++;
        }

        return position;
    }
}
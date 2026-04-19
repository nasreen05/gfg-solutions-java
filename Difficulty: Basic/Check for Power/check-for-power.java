class Solution {
    public boolean isPower(int x, int y) {
        // Edge case
        if (y == 1) return true;
        if (x == 1) return false;

        // Keep dividing y by x while divisible
        while (y % x == 0) {
            y = y / x;
        }

        // If we reach 1, it is a power
        return y == 1;
    }
}

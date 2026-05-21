class Solution {
    public boolean isBitSet(int n) {
        // 0 should return false
        if (n == 0) return false;
        
        // A number with all bits set satisfies:
        // n & (n + 1) == 0
        return (n & (n + 1)) == 0;
    }
}
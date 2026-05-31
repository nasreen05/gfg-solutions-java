class Solution {
    public boolean isSumOfConsecutive(int n) {
        // n can be expressed as sum of consecutive numbers if it's NOT a power of 2
        // A number is a power of 2 if (n & (n-1)) == 0
        return (n & (n - 1)) != 0;
    }
}
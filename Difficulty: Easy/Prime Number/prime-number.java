class Solution {
    static boolean isPrime(int n) {
        // 1 is not a prime number
        if (n <= 1) {
            return false;
        }

        // Check divisibility up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

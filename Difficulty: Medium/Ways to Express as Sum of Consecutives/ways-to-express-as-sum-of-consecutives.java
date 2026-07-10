class Solution {
    public int getCount(int n) {
        
        // Remove all factors of 2
        while (n % 2 == 0) {
            n /= 2;
        }

        int divisors = 1;

        for (int i = 3; i * i <= n; i += 2) {
            int count = 0;

            while (n % i == 0) {
                count++;
                n /= i;
            }

            divisors *= (count + 1);
        }

        if (n > 1) {
            divisors *= 2;
        }

        return divisors - 1;
    }
}
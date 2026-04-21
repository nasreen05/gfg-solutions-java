class Solution {
    
    public int minSteps(int m, int n, int d) {
        
        // If d is greater than both jugs
        if (d > Math.max(m, n)) return -1;
        
        // If d not divisible by gcd(m,n)
        if (d % gcd(m, n) != 0) return -1;
        
        // Return minimum steps from both directions
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
    
    // Function to simulate pouring from one jug to another
    private int pour(int fromCap, int toCap, int d) {
        
        int from = fromCap; // Fill from jug
        int to = 0;         // To jug empty
        
        int step = 1;       // First step: fill
        
        while (from != d && to != d) {
            
            // Pour water
            int temp = Math.min(from, toCap - to);
            to += temp;
            from -= temp;
            
            step++;
            
            // Check condition
            if (from == d || to == d)
                break;
            
            // If from jug empty → refill
            if (from == 0) {
                from = fromCap;
                step++;
            }
            
            // If to jug full → empty
            if (to == toCap) {
                to = 0;
                step++;
            }
        }
        
        return step;
    }
    
    // Function to calculate gcd
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
